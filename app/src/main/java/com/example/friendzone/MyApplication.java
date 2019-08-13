package com.example.friendzone;
//tanggal 12/08/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("mahasiswa.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

}
