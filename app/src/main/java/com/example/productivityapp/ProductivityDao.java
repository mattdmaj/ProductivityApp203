package com.example.productivityapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductivityDao {
    @Query("SELECT * FROM points")
    // want a list of points BUT int is technically returned instead.
    LiveData<List<Points>> getPoints();

    /*@Update
    // Todo: how will we update the points? Will we pass in the number of
    //  points earned and add that to the current value?
    public void updatePoints();
    */
}
