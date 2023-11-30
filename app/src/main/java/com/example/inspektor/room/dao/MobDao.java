package com.example.inspektor.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inspektor.room.entity.MobEntity;

@Dao
public interface MobDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MobEntity mob);

    @Query("SELECT * FROM Inspec_Mob")
    LiveData<MobEntity> getAll();

    @Query("DELETE FROM Inspec_Mob")
    void deleteAll();

}
