package com.example.productivityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class SettingsScreen extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    ToggleButton toggleButton;
    Switch NightSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

        constraintLayout = findViewById(R.id.constraintLayout);
        toggleButton = findViewById(R.id.toggleButton);
        NightSwitch = findViewById(R.id.NightSwitch);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        SharedPreferences sharedPreferences = getSharedPreferences("save",MODE_PRIVATE);
        toggleButton.setChecked(sharedPreferences.getBoolean("value", true));

        //This is the "about us" button which will bring the user to a new screen.
        ImageButton imageButton = findViewById(R.id.Infobutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsScreen.this, AboutUsScreen.class);
                startActivity(intent);
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If notification button is on, it is checked and will stay on when exiting the screen.
                if (toggleButton.isChecked()) {

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(SettingsScreen.this, "My Notification");
                    builder.setContentTitle("Productivity App");
                    builder.setContentText("Long time no see, come study soon :D ");
                    builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(SettingsScreen.this);
                    managerCompat.notify(1,builder.build());

                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    toggleButton.setChecked(true);
                    showSnackBar();
                }
                //If notification button is turned off, it will execute the opposite.
                else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    toggleButton.setChecked(false);
                    showSnackBar2();
                }

            }
        });

        NightSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NightSwitch.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    NightSwitch.setChecked(true);
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    NightSwitch.setChecked(false);
                }
            }
        });

    }

        //Snackbar for enabled notifications
        public void showSnackBar() {
            Snackbar snackbar = Snackbar.make(constraintLayout, "Push Notifications Enabled.", 2000);
            snackbar.show();
        }

        //Snackbar for disabled notifications
        public void showSnackBar2() {
            Snackbar snackbar = Snackbar.make(constraintLayout, "Push Notifications Disabled.", 2000);
            snackbar.show();
        }

        @Override
        public void recreate(){
            finish();
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            startActivity(getIntent());
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        }


    }
