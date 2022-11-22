package com.example.productivityapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PointsViewModel extends AndroidViewModel {
    private ProductivityRepository mRepository;
    // this is Originally an integer, but may need to become a liveData list
    //private final LiveData<List<Points>> mPoints;

    public PointsViewModel(Application application){
        super(application);
        //mRepository = new ProductivityRepository
    }
}
