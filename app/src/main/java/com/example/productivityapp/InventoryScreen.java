package com.example.productivityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.productivityapp.databinding.ActivityMainBinding;
import com.example.productivityapp.ui.home.HomeFragment;

public class InventoryScreen extends AppCompatActivity {
    boolean[] own = {true,true,false,false,false,false};

    public Bundle change = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_screen);

        Button base = findViewById(R.id.base_button);
        base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(own[0] == false){

                } else {
                    Intent basepass = new Intent(InventoryScreen.this, HomeFragment.class);
                    basepass.putExtra("enable","visible");
                    startActivity(basepass);
                }
            }
        });

        Button swim = findViewById(R.id.swim_button);
        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(own[1] == false){

                } else {
                    Intent swimpass = new Intent(InventoryScreen.this, HomeFragment.class);
                    swimpass.putExtra("enable","visible");
                    startActivity(swimpass);
                }
            }
        });
        Button doc = findViewById(R.id.doc_button);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(own[2] == false){

                } else {

                }
            }
        });
        Button gang = findViewById(R.id.gang_button);
        gang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(own[3] == false){

                } else {

                }
            }
        });
        Button nes = findViewById(R.id.nes_button);
        nes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(own[4] == false){

                } else {

                }
            }
        });
        Button school = findViewById(R.id.school_button);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(own[5] == false){

                } else {

                }
            }
        });
    }

}