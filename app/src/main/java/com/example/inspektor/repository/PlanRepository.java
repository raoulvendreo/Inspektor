package com.example.inspektor.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inspektor.room.RoomDb;
import com.example.inspektor.room.dao.PlanDao;
import com.example.inspektor.room.entity.PlanEntity;

public class PlanRepository {

    public PlanDao mPlanDao;
    private LiveData<PlanEntity> mAllPlanData;

    public PlanRepository(Application application){
        RoomDb roomDb = RoomDb.getInstance(application);
        mPlanDao = roomDb.planDao();
    }

    public void insert(PlanEntity planEntity){
        RoomDb.databaseWriteExecutor.execute(()->{
            mPlanDao.insert(planEntity);
        });
    }

    public LiveData<PlanEntity> getmAllPlanData(){
        return mAllPlanData;
    }
}
