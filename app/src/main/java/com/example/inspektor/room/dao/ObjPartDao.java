package com.example.inspektor.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inspektor.room.entity.ObjPartEntity;

import java.util.List;

@Dao
public interface ObjPartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ObjPartEntity objPartEntity);

    @Query("SELECT * FROM ObjPartTable")
    LiveData<List<ObjPartEntity>> getAll();

    @Query("DELETE FROM ObjPartTable")
    void deleteAll();
}
