package com.example.productivityapp;

import android.app.Application;
import android.os.AsyncTask;

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

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void update(Points points) {
        RoomDatabase.databaseWriteExecutor.execute(() -> {
            mProductivityDao.updatePoints(points);
        });
    }
}
