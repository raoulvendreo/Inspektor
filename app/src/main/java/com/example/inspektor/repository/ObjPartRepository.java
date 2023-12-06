package com.example.inspektor.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inspektor.room.RoomDb;
import com.example.inspektor.room.dao.ObjPartDao;
import com.example.inspektor.room.entity.ObjPartEntity;

public class ObjPartRepository {

    public ObjPartDao mObjPartDao;
    private LiveData<ObjPartEntity> mAllObjPartData;

    public ObjPartRepository(Application application){
        RoomDb roomDb = RoomDb.getInstance(application);
        mObjPartDao = roomDb.objPartDao();
    }

    public void insert(ObjPartEntity objPartEntity){
        RoomDb.databaseWriteExecutor.execute(()->{
            mObjPartDao.insert(objPartEntity);
        });
    }

    public LiveData<ObjPartEntity> getmAllObjPartData(){
        return mAllObjPartData;
    }
}
