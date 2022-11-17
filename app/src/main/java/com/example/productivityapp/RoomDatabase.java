package com.example.productivityapp;

import androidx.room.Database;

@Database(entities = {Points.class}, version = 1, exportSchema = false)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
    public abstract PointsDao pointsDao();

}
