package com.example.inspektor.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inspektor.room.entity.MobEntity;

import java.util.List;

@Dao
public interface MobDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MobEntity mobEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(MobEntity mobEntities);
    @Query("SELECT * FROM MobTable")
    LiveData<List<MobEntity>> getAll();

    @Query("DELETE FROM MobTable")
    void deleteAll();
}
