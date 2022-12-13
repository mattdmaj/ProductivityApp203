package com.example.productivityapp.ui.home;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productivityapp.InventoryScreen;
import com.example.productivityapp.MainActivity;
import com.example.productivityapp.Points;
import com.example.productivityapp.PointsAdapter;
import com.example.productivityapp.PointsViewModel;
import com.example.productivityapp.R;
import com.example.productivityapp.ScheduleTask;
import com.example.productivityapp.SettingsScreen;
import com.example.productivityapp.databinding.ActivityMainBinding;
import com.example.productivityapp.databinding.FragmentHomeBinding;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Points newPoints = new Points(1000);
    private int pointsInt;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        TextView timer = (TextView) homeView.findViewById(R.id.timer_view);

        //Settings Screen
        Button buttonS = (Button) homeView.findViewById(R.id.settings);
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getActivity(), SettingsScreen.class);
                startActivity(intent);
            }
        });

        //Inventory screen
        Button buttonI = (Button) homeView.findViewById(R.id.inventory);
        buttonI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getActivity(), InventoryScreen.class);
                startActivity(intent);
            }
        });

        Button startButton = (Button) homeView.findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long hoursConverted = ScheduleTask.hoursToConvert * 3600000L;
                long minutesConverted = ScheduleTask.minutesToConvert * 60000L;
                long secondsConverted = ScheduleTask.secondsToConvert * 1000L;
                long countdownTime = hoursConverted + minutesConverted + secondsConverted;

                CountDownTimer countdown = new CountDownTimer(countdownTime, 1000) {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public void onTick(long l) {
                        String currentTime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(l),
                            TimeUnit.MILLISECONDS.toMinutes(l) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(l)),
                            TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                        timer.setText(currentTime);
                    }

                    @Override
                    public void onFinish() {
                        timer.setText("Finished!");
                    }
                };
                countdown.start();
            }
        });

        PointsViewModel pointsViewModel = new ViewModelProvider(this).get(PointsViewModel.class);

        TextView pointsTextView = homeView.findViewById(R.id.money);

        pointsInt = pointsViewModel.getPoints();

        // if we have an int and set it equal to a points object's
        // getPoints, we can update the points this way
        pointsInt = newPoints.getPoints();

        String pointsString = Integer.toString(pointsInt);

        pointsTextView.setText(pointsString);

        return homeView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}