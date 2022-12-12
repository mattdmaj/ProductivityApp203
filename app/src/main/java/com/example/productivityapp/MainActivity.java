package com.example.productivityapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productivityapp.databinding.ActivityMainBinding;

import java.util.Objects;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    private PointsViewModel mPointsViewModel;

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ImageView pic0 = findViewById(R.id.avatar);
        ImageView pic1 = findViewById(R.id.swim);
        ImageView pic2 = findViewById(R.id.doc);
        ImageView pic3 = findViewById(R.id.gang);
        ImageView pic4 = findViewById(R.id.nes);
        ImageView pic5 = findViewById(R.id.school);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String enable0 = extras.getString("enable");

            if (Objects.equals(enable0, "visible")){
                    pic0.setVisibility(View.VISIBLE);
                    pic1.setVisibility(View.INVISIBLE);
                    pic2.setVisibility(View.INVISIBLE);
                    pic3.setVisibility(View.INVISIBLE);
                    pic4.setVisibility(View.INVISIBLE);
                    pic5.setVisibility(View.INVISIBLE);
            }
        }

        Bundle extras1 = getIntent().getExtras();
        if (extras1 != null) {
            String enable1 = extras1.getString("enable1");

            if (Objects.equals(enable1, "visible")){
                pic0.setVisibility(View.INVISIBLE);
                pic1.setVisibility(View.VISIBLE);
                pic2.setVisibility(View.INVISIBLE);
                pic3.setVisibility(View.INVISIBLE);
                pic4.setVisibility(View.INVISIBLE);
                pic5.setVisibility(View.INVISIBLE);
            }
        }

        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null) {
            String enable2 = extras2.getString("enable2");

            if (Objects.equals(enable2, "visible")){
                pic0.setVisibility(View.INVISIBLE);
                pic1.setVisibility(View.INVISIBLE);
                pic2.setVisibility(View.VISIBLE);
                pic3.setVisibility(View.INVISIBLE);
                pic4.setVisibility(View.INVISIBLE);
                pic5.setVisibility(View.INVISIBLE);
            }
        }

        Bundle extras3 = getIntent().getExtras();
        if (extras3 != null) {
            String enable3 = extras3.getString("enable3");

            if (Objects.equals(enable3, "visible")){
                pic0.setVisibility(View.INVISIBLE);
                pic1.setVisibility(View.INVISIBLE);
                pic2.setVisibility(View.INVISIBLE);
                pic3.setVisibility(View.VISIBLE);
                pic4.setVisibility(View.INVISIBLE);
                pic5.setVisibility(View.INVISIBLE);
            }
        }
        Bundle extras4 = getIntent().getExtras();
        if (extras4 != null) {
            String enable4 = extras4.getString("enable4");

            if (Objects.equals(enable4, "visible")){
                pic0.setVisibility(View.INVISIBLE);
                pic1.setVisibility(View.INVISIBLE);
                pic2.setVisibility(View.INVISIBLE);
                pic3.setVisibility(View.INVISIBLE);
                pic4.setVisibility(View.VISIBLE);
                pic5.setVisibility(View.INVISIBLE);
            }
        }

        Bundle extras5 = getIntent().getExtras();
        if (extras5 != null) {
            String enable5 = extras5.getString("enable5");

            if (Objects.equals(enable5, "visible")){
                pic0.setVisibility(View.INVISIBLE);
                pic1.setVisibility(View.INVISIBLE);
                pic2.setVisibility(View.INVISIBLE);
                pic3.setVisibility(View.INVISIBLE);
                pic4.setVisibility(View.INVISIBLE);
                pic5.setVisibility(View.VISIBLE);
            }
        }
        SharedPreferences switchPref = getSharedPreferences("save2", MODE_PRIVATE);
        boolean isNightMode = switchPref.getBoolean("Night",true);
        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_calendar)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }

}

