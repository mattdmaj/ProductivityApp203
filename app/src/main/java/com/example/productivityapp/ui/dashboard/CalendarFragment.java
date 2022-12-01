package com.example.productivityapp.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.productivityapp.R;
import com.example.productivityapp.ScheduleTask;

public class CalendarFragment extends Fragment {

    private CalendarFragment binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View calendarFragmentView = inflater.inflate(R.layout.fragment_calendar, container, false);

        CalendarView calendarView = calendarFragmentView.findViewById(R.id.calendar);
        TextView textView = calendarFragmentView.findViewById(R.id.date_view_field);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                String date = year + "/" + (month + 1) + "/" + day;
            textView.setText(date);
            }
        });

        Button scheduleButton = (Button) calendarFragmentView.findViewById(R.id.schedule_button);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getActivity(), ScheduleTask.class);
                startActivity(intent);
            }
        });


        return calendarFragmentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}