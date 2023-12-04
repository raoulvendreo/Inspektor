package com.example.inspektor.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inspektor.room.RoomDb;
import com.example.inspektor.room.dao.UserDao;
import com.example.inspektor.room.entity.UserEntity;

public class UserRepository {

    private final UserDao mUserDao;
    private final LiveData<UserEntity> mAllUserData;

    public UserRepository(Application application){
        RoomDb roomDb = RoomDb.getInstance(application);
        mUserDao = roomDb.userDao();
        mAllUserData = mUserDao.getAll();
    }

    public void insert(UserEntity userEntity){
        RoomDb.databaseWriteExecutor.execute(()->{
            mUserDao.insert(userEntity);
        });
    }

    public LiveData<UserEntity> getmAllUserData() {
        return mAllUserData;
    }
}
