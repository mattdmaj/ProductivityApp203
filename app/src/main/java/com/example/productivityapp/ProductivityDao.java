package com.example.productivityapp;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import java.util.List;

public interface ProductivityDao {
    @Query("SELECT * FROM points")
    // want a list of points BUT int is technically returned instead.
    LiveData<List<Points>> getPoints();
}
