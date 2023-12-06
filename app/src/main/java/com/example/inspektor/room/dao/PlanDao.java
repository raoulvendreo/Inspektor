package com.example.inspektor.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inspektor.room.entity.PlanEntity;

import java.util.List;

@Dao
public interface PlanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PlanEntity planEntity);

    @Query("SELECT * FROM PlanTable")
    LiveData<List<PlanEntity>> getAll();

    @Query("DELETE FROM PlanTable")
    void deleteAll();
}
