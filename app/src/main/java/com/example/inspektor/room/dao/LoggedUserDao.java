package com.example.inspektor.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inspektor.room.entity.LoggedUserEntity;

@Dao
public interface LoggedUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LoggedUserEntity userLogin);

    @Query("SELECT * FROM Logged_User_Data")
    LiveData<LoggedUserEntity> getAll();

    @Query("DELETE FROM Logged_User_Data")
    void deleteAll();
}
