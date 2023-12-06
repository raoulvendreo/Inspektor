package com.example.inspektor.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inspektor.room.RoomDb;
import com.example.inspektor.room.dao.VecTypeDao;
import com.example.inspektor.room.entity.VecTypeEntity;

public class VecTypeRepository {

    public VecTypeDao mVecTypeDao;
    private LiveData<VecTypeEntity> mAllVecTypeData;

    public VecTypeRepository(Application application){
        RoomDb roomDb = RoomDb.getInstance(application);
        mVecTypeDao = roomDb.vecTypeDao();
    }

    public void insert(VecTypeEntity vecTypeEntity){
        RoomDb.databaseWriteExecutor.execute(()->{
            mVecTypeDao.insert(vecTypeEntity);
        });
    }

    public LiveData<VecTypeEntity> getmAllVecTypeData(){
        return mAllVecTypeData;
    }
}
