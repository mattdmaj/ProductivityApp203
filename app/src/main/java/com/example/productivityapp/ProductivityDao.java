package com.example.productivityapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductivityDao {
    @Query("SELECT MAX(POINTS) FROM points")
    int getPoints();

    @Insert
    void insert(Points points);

    @Update
    public void updatePoints(Points points);
}
