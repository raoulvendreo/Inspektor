package com.example.inspektor.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inspektor.room.RoomDb;
import com.example.inspektor.room.dao.RunAcctDao;
import com.example.inspektor.room.entity.RunAcctEntity;

public class RunAcctRepository {

    public RunAcctDao mRunAcctDao;
    private LiveData<RunAcctEntity> mAllRunAcctData;

    public RunAcctRepository(Application application){
        RoomDb roomDb = RoomDb.getInstance(application);
        mRunAcctDao = roomDb.runAcctDao();
    }

    public void insert(RunAcctEntity runAcctEntity){
        RoomDb.databaseWriteExecutor.execute(()->{
            mRunAcctDao.insert(runAcctEntity);
        });
    }

    public LiveData<RunAcctEntity> getmAllRunAcctData(){
        return mAllRunAcctData;
    }
}
