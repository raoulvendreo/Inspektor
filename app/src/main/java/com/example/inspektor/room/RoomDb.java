package com.example.inspektor.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.inspektor.room.dao.MobDao;
import com.example.inspektor.room.dao.ObjPartDao;
import com.example.inspektor.room.dao.PlanDao;
import com.example.inspektor.room.dao.RunAcctDao;
import com.example.inspektor.room.dao.UserDao;
import com.example.inspektor.room.dao.VecTypeDao;
import com.example.inspektor.room.entity.MobEntity;
import com.example.inspektor.room.entity.ObjPartEntity;
import com.example.inspektor.room.entity.PlanEntity;
import com.example.inspektor.room.entity.RunAcctEntity;
import com.example.inspektor.room.entity.UserEntity;
import com.example.inspektor.room.entity.VecTypeEntity;
import com.example.inspektor.typeconverters.CompanyTypeConverter;
import com.example.inspektor.typeconverters.EstatesTypeConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserEntity.class, MobEntity.class, ObjPartEntity.class, PlanEntity.class, RunAcctEntity.class, VecTypeEntity.class}, version = 3, exportSchema = false)
@TypeConverters({CompanyTypeConverter.class, EstatesTypeConverter.class})
public abstract class RoomDb extends RoomDatabase {

    //DAO di sini
    public abstract UserDao userDao();
    public abstract MobDao mobDao();
    public abstract ObjPartDao objPartDao();

    public abstract PlanDao planDao();

    public abstract RunAcctDao runAcctDao();

    public abstract VecTypeDao vecTypeDao();

    private static volatile RoomDb INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

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

                UserDao userDao = INSTANCE.userDao();
                userDao.deleteAll();

                MobDao mobDao = INSTANCE.mobDao();
                mobDao.deleteAll();

                ObjPartDao objPartDao = INSTANCE.objPartDao();
                objPartDao.deleteAll();

                PlanDao planDao = INSTANCE.planDao();
                planDao.deleteAll();

                RunAcctDao runAcctDao = INSTANCE.runAcctDao();
                runAcctDao.deleteAll();

                VecTypeDao vecTypeDao = INSTANCE.vecTypeDao();
                vecTypeDao.deleteAll();
            });
        }
    };
}
