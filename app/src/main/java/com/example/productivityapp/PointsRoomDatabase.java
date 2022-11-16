package com.example.productivityapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Points.class}, version = 1, exportSchema = false)
public abstract class PointsRoomDatabase extends RoomDatabase {

}
