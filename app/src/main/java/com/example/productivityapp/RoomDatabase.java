package com.example.productivityapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Points.class}, version = 1, exportSchema = false)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
/*    public abstract PointsDao pointsDao();

    // this is a singleton, which means that only one will be made
    // and so, there is only one instance of the database
    private static volatile RoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static RoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RoomDatabase.class, "productivity_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }*/
}
