package com.example.productivityapp.ui.home;

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

import com.example.productivityapp.InventoryScreen;
import com.example.productivityapp.MainActivity;
import com.example.productivityapp.R;
import com.example.productivityapp.SettingsScreen;
import com.example.productivityapp.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] visible = {"visible","invisible","invisible","invisible","invisible","invisible"};
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View homeView = inflater.inflate(R.layout.fragment_home, container, false);


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

       // final TextView textView = binding.textHome;
       // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return homeView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}