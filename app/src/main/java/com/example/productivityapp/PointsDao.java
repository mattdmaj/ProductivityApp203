package com.example.productivityapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface PointsDao {

    @Query("SELECT * FROM points")
    int getPoints();
}
