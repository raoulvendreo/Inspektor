package com.example.inspektor.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inspektor.room.entity.PlanEntity;

@Dao
public interface PlanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PlanEntity plan);

    @Query("SELECT * FROM Inspec_Plan")
    LiveData<PlanEntity> getAll();

    @Query("DELETE FROM Inspec_Plan")
    void deleteAll();

}
