package com.example.productivityapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Update;

import java.util.List;


/*
VIEW MODEL
-------------
View model is the middle between the UI and the Data
* */
public class PointsViewModel extends AndroidViewModel {
    private RoomDatabase pointsDB;
    private ProductivityRepository mRepository;
    private ProductivityDao productivityDao;

    private final int mPoints;

    public PointsViewModel(Application application){
        super(application);

        pointsDB = RoomDatabase.getDatabase(application);
        mRepository = new ProductivityRepository(application);
        mPoints = mRepository.getPoints();
    }

    public int getPoints() { return mPoints; }

    public void update(Points points) { mRepository.update(points);}
}
