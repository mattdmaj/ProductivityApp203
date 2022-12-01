package com.example.productivityapp;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.annotation.NonNull;

public class CalendarActivity extends MainActivity {
    CalendarView calendarView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendar);
        textView = findViewById(R.id.date_view_field);

        new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day)
            {
                String Date = (month + 1) + "/" + day + "/" + year;
                textView.setText(Date);
            }
        };
    }
}