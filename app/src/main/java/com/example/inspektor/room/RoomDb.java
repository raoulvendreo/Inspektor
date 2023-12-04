package com.example.inspektor.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.inspektor.room.dao.UserDao;
import com.example.inspektor.room.entity.UserEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserEntity.class}, version = 1, exportSchema = false)

public abstract class RoomDb extends RoomDatabase {

    //DAO di sini
    public abstract UserDao userDao();


    private static volatile RoomDb INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static String DATABASE_NAME = "Inspection_RA.db";

    public static RoomDb getInstance(Context context){
        if (INSTANCE == null){
            synchronized (RoomDb.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context,
                                    RoomDb.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .addCallback(myRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback myRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more data, just add them.

                UserDao dao = INSTANCE.userDao();
                dao.deleteAll();
            });
        }
    };
}
