package com.example.productivityapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "points")
public class Points {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "points")
    public int mPoints = 0;

    public Points(@NonNull int points) {this.mPoints = points;}

    public int getPoints() {return this.mPoints;}

}
