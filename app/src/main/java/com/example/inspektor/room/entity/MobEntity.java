package com.example.inspektor.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "MobTable")
public class MobEntity implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String mobId;

    @ColumnInfo(name = "no_inspec")
    private String noInspec;

}
