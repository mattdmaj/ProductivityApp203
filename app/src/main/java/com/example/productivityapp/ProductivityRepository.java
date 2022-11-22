package com.example.productivityapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
// Todo: So far the project runs OK with no errors WITHOUT repository,
//  get Room working using only the DAO and entity
public class ProductivityRepository {

    private ProductivityDao mProductivityDao;
    private LiveData<List<Points>> mPoints;

    ProductivityRepository(Application application){
        RoomDatabase db = RoomDatabase.getDatabase(application);
        mProductivityDao = db.productivityDao();
    }

    LiveData<List<Points>> getPoints(){
        return mPoints;
    }

}
