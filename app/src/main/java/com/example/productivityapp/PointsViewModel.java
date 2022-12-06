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

    // this is Originally an integer, but may need to become a liveData list
    private final LiveData<List<Points>> mPoints;

    public PointsViewModel(Application application){
        super(application);

        pointsDB = RoomDatabase.getDatabase(application);
        mRepository = new ProductivityRepository(application);
        mPoints = mRepository.getPoints();
    }

    public LiveData<List<Points>> getPoints() { return mPoints; }

    /* THIS COULD BE IMPLEMENTED LATER.
    @Update */
}
