package com.example.productivityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.productivityapp.databinding.ActivityMainBinding;
import com.example.productivityapp.ui.home.HomeFragment;

public class InventoryScreen extends AppCompatActivity {
    boolean[] own = {true,true,false,false,false,false};//tracks own outfits, all but base false by default

    public Bundle change = new Bundle();//bundles allow communication between files
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_screen);
        ProductivityDao productivityDao = new ProductivityDao() {
            @Override
            public int getPoints() {
                return 0;
            }

            @Override
            public void insert(Points points) {

            }
        };

        String[] seen = {"visible","invisible","invisible","invisible","invisible","invisible"};
        Button base = findViewById(R.id.base_button);
        if(productivityDao.getPoints() == 500) {
            own[1] = true;
        }else if(productivityDao.getPoints() == 1000){
            own[2] = true;
        }else if(productivityDao.getPoints() == 1500){
            own[3] = true;
        }else if(productivityDao.getPoints() == 2000){
            own[4] = true;
        }else if(productivityDao.getPoints() == 2500){
            own[5] = true;
        }
        base.setOnClickListener(new View.OnClickListener() {
            //each of these tracks when the corresponding button is pressed it then will check
            //if the user owns the outfit they wish to purchase , if not they are given a message
            @Override
            public void onClick(View view) {
                if(own[0] == false){
                    Toast.makeText(getApplicationContext(),"You dont own this ",Toast.LENGTH_LONG).show();
                } else {
                    Intent basepass = new Intent(InventoryScreen.this, MainActivity.class);
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
                    Toast.makeText(getApplicationContext(),"You dont own this ",Toast.LENGTH_LONG).show();
                } else {
                    Intent swimpass = new Intent(InventoryScreen.this, MainActivity.class);
                    swimpass.putExtra("enable1","visible");
                    startActivity(swimpass);
                }
            }
        });
        Button doc = findViewById(R.id.doc_button);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(own[2] == false){
                    Toast.makeText(getApplicationContext(),"You dont own this ",Toast.LENGTH_LONG).show();
                } else {
                    Intent docpass = new Intent(InventoryScreen.this, MainActivity.class);
                    docpass.putExtra("enable2","visible");
                    startActivity(docpass);
                }
            }
        });
        Button gang = findViewById(R.id.gang_button);
        gang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(own[3] == false){
                    Toast.makeText(getApplicationContext(),"You dont own this ",Toast.LENGTH_LONG).show();
                } else {
                    Intent gangpass = new Intent(InventoryScreen.this, MainActivity.class);
                    gangpass.putExtra("enable3","visible");
                    startActivity(gangpass);
                }
            }
        });
        Button nes = findViewById(R.id.nes_button);
        nes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(own[4] == false){
                    Toast.makeText(getApplicationContext(),"You dont own this ",Toast.LENGTH_LONG).show();
                } else {
                    Intent nespass = new Intent(InventoryScreen.this, MainActivity.class);
                    nespass.putExtra("enable4","visible");
                    startActivity(nespass);
                }
            }
        });
        Button school = findViewById(R.id.school_button);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(own[5] == false){
                    Toast.makeText(getApplicationContext(),"You dont own this ",Toast.LENGTH_LONG).show();
                } else {
                    Intent schoolpass = new Intent(InventoryScreen.this, MainActivity.class);
                    schoolpass.putExtra("enable5","visible");
                    startActivity(schoolpass);
                }
            }
        });
    }

}