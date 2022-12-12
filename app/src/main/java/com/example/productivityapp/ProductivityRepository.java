package com.example.productivityapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executors;

// Todo: So far the project runs OK with no errors WITHOUT repository,
//  get Room working using only the DAO and entity
public class ProductivityRepository {

    private ProductivityDao mProductivityDao;
    private int mPoints;

    ProductivityRepository(Application application){
        RoomDatabase db = RoomDatabase.getDatabase(application);
        mProductivityDao = db.productivityDao();
        //mPoints = mProductivityDao.getPoints();
        //run in background task
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                mPoints = mProductivityDao.getPoints();
            }
        });
    }

    int getPoints(){
        return mPoints;
    }

}
