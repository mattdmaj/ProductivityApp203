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
    // want a list of points BUT int is technically returned instead.
    int getPoints();

    @Insert
    void insert(Points points);

    /*@Update
    // Todo: how will we update the points? Will we pass in the number of
    //  points earned and add that to the current value?
    public void updatePoints();
    */
}