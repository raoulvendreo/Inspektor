package com.example.inspektor.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inspektor.room.entity.UserLoginEntity;

@Dao
public interface UserLoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserLoginEntity userLogin);

    @Query("SELECT * FROM User_Login_Data")
    LiveData<UserLoginEntity> getAll();

    @Query("DELETE FROM User_Login_Data")
    void deleteAll();
}
