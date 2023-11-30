package com.example.inspektor.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.inspektor.room.entity.RunningAccountEntity;

import java.util.List;

@Dao
public interface RunningAccountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RunningAccountEntity runningAccount);

    @Query("SELECT * FROM Inspec_RunningAccount")
    LiveData<List<RunningAccountEntity>> getAll();

    @Query("DELETE FROM Inspec_RunningAccount")
    void deleteAll();

}
