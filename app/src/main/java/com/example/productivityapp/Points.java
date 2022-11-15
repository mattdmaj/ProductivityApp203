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
    public int points;

    public Points(@NonNull int points) {this.points = points;}

    public int getPoints(){
        return this.points;
    }
}
