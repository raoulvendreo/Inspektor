package com.example.inspektor.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inspektor.room.entity.VecTypeEntity;

@Dao
public interface VecTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(VecTypeEntity vecTypeEntity);

    @Query("SELECT * FROM VehicleTypeTable")
    LiveData<VecTypeEntity> getAll();

    @Query("DELETE FROM VehicleTypeTable")
    void deleteAll();

}
