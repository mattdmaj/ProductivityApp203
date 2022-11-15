package com.example.productivityapp.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.productivityapp.R;
import com.example.productivityapp.databinding.FragmentCalendarBinding;

public class CalendarFragment extends Fragment {

    private CalendarFragment binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        CalendarView calendarView = view.findViewById(R.id.calendar);
        TextView textView = view.findViewById(R.id.textView3);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
            String date = year + "/" + (month + 2) + "/" + day;
            textView.setText(date);
            }
        });

        Button button = (Button) view.findViewById(R.id.schedule_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("myTag", "This is a test");
            }

        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}