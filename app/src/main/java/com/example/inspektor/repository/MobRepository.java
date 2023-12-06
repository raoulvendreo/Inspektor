package com.example.inspektor.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inspektor.room.RoomDb;
import com.example.inspektor.room.dao.MobDao;
import com.example.inspektor.room.entity.MobEntity;

public class MobRepository {

    public MobDao mMobDao;
//    private LiveData<List<MobEntity>> mAllMobData;
    private LiveData<MobEntity> mAllMobData;

    public MobRepository(Application application){
        RoomDb roomDb = RoomDb.getInstance(application);
        mMobDao = roomDb.mobDao();
//        mAllMobData = mMobDao.getAll();
    }

    public void insert(MobEntity mobEntity){
        RoomDb.databaseWriteExecutor.execute(()->{
            mMobDao.insert(mobEntity);
        });
    }

    public void insertAll(MobEntity mobEntities){
        RoomDb.databaseWriteExecutor.execute(() -> {
            mMobDao.insertAll(mobEntities);
        });
    }

//    public LiveData<List<MobEntity>> getmAllMobData(){
//        return mAllMobData;
//    }

    public LiveData<MobEntity> getmAllMobData(){
        return mAllMobData;
    }
}
