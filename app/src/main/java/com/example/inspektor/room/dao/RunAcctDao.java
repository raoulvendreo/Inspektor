package com.example.inspektor.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inspektor.room.entity.RunAcctEntity;

@Dao
public interface RunAcctDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RunAcctEntity runAcctEntity);

    @Query("SELECT * FROM RunningAccountTable")
    LiveData<RunAcctEntity> getAll();

    @Query("DELETE FROM RunningAccountTable")
    void deleteAll();

}
