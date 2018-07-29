package com.willy.example.customcar.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.willy.example.customcar.classes.AutoPart;
import com.willy.example.customcar.enums.AutoPartType;

import java.util.List;

@Dao
public interface DataDao {

    @Query("SELECT * FROM AutoPart")
    List<AutoPart> getAll();

    @Query("SELECT * FROM AutoPart WHERE type = :type")
    public List<AutoPart> getPartsOfType(int type);

    @Insert
    void insertAll(AutoPart...autoParts);

}
