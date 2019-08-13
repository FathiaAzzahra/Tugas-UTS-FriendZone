package com.example.friendzone.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.friendzone.R;


//tanggal 18/05/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn_logout = (Button) findViewById(R.id.btnLogout);
        btn_logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                logout();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.mBottomNavBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

    }


    private void logout(){
        SharedPreferences sharedpreferences = getSharedPreferences(Main3Activity.my_shared_preferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(Main3Activity.session_status, false);
        editor.putString(Main3Activity.TAG_ID, null);
        editor.putString(Main3Activity.TAG_EMAIL, null);
        editor.putString(Main3Activity.TAG_NAME, null);
        editor.putString(Main3Activity.TAG_PHONE, null);
        editor.commit();
        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        finish();
        startActivity(intent);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId())
                    {
                        case R.id.nav_profile:
                            break;
                        case R.id.nav_contact:
                            Intent intent2 = new Intent(Main2Activity.this, Main4Activity.class);
                            startActivity(intent2);
                            break;
                        case R.id.nav_friends:
                            Intent intent3 = new Intent(Main2Activity.this, Main5Activity.class);
                            startActivity(intent3);
                            break;
                    }
                    return false;
                }
            };
}
