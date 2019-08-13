package com.example.friendzone.view;
//tanggal 12/08/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.friendzone.R;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        BottomNavigationView bottomNavigationView = findViewById(R.id.mBottomNavBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId())
                    {
                        case R.id.nav_profile:
                            Intent intent1 = new Intent(Main4Activity.this, Main2Activity.class);
                            startActivity(intent1);
                            break;
                        case R.id.nav_contact:
                            break;
                        case R.id.nav_friends:
                            Intent intent3 = new Intent(Main4Activity.this, Main5Activity.class);
                            startActivity(intent3);
                            break;
                    }
                    return false;
                }
            };
}
