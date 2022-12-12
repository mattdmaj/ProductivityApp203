package com.example.productivityapp.ui.home;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.productivityapp.SettingsScreen;
import com.example.productivityapp.databinding.ActivityMainBinding;
import com.example.productivityapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private int pointsInt = 0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        /*RecyclerView recyclerView = homeView.findViewById(R.id.money);
        recyclerView.setHasFixedSize(true);
        PointsAdapter adapter = new PointsAdapter(new PointsAdapter.PointsDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        PointsViewModel mPointsViewModel = new ViewModelProvider(this).get(PointsViewModel.class);

        // trying to execute the following line but cannot because it is trying to do stuff on something that is NULL
        mPointsViewModel.getPoints().observe(getViewLifecycleOwner(), points -> { adapter.submitList(points); });*/

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

        PointsViewModel pointsViewModel = new ViewModelProvider(this).get(PointsViewModel.class);

        TextView pointsTextView = homeView.findViewById(R.id.money);

        pointsInt = pointsViewModel.getPoints();

        System.out.println(pointsInt);

        String pointsString = Integer.toString(pointsInt);

        System.out.println(pointsInt);

        pointsTextView.setText(pointsString);

        return homeView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}