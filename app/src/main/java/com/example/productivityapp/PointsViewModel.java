package com.example.productivityapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


/*
VIEW MODEL
-------------
View model is the middle between the UI and the Data
* */
public class PointsViewModel extends AndroidViewModel {
    private ProductivityRepository mRepository;

    // this is Originally an integer, but may need to become a liveData list
    private LiveData<List<Points>> mPoints;

    public PointsViewModel(Application application){
        super(application);
        mRepository = new ProductivityRepository(application);
        mPoints = mRepository.getPoints();
    }


    LiveData<List<Points>> getPoints() { return mPoints; }
}
