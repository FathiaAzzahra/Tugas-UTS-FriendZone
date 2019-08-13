package com.example.friendzone.view;
//tanggal 12/08/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.friendzone.MahasiswaActivity;
import com.example.friendzone.MahasiswaModel;
import com.example.friendzone.R;
import com.example.friendzone.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener {

    Button btnSimpan, btnTampil;
    EditText   nim, nama,kelas,telpon,email,sosmed;
    String sNama,sKelas,sTelpon,sEmail,sSosmed;
    Integer sNim;
    Realm realm;
    RealmHelper realmHelper;
    MahasiswaModel mahasiswaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //Inisialisasi
        btnSimpan = findViewById(R.id.btnSimpan);
        btnTampil = findViewById(R.id.btnTampil);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);

        //Set up Realm
        Realm.init(Main5Activity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btnSimpan.setOnClickListener(this);
        btnTampil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSimpan){
            sNim = Integer.parseInt(nim.getText().toString());
            sNama = nama.getText().toString();
            sKelas = kelas.getText().toString();
            sTelpon = telpon.getText().toString();
            sEmail = email.getText().toString();
            sSosmed = sosmed.getText().toString();

            if (!sNim.equals("") && !sNama.isEmpty()){
                mahasiswaModel = new MahasiswaModel();
                mahasiswaModel.setNim(sNim);
                mahasiswaModel.setNama(sNama);
                mahasiswaModel.setKelas(sKelas);
                mahasiswaModel.setTelpon(sTelpon);
                mahasiswaModel.setEmail(sEmail);
                mahasiswaModel.setSosmed(sSosmed);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(mahasiswaModel);

                Toast.makeText(Main5Activity.this, "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                nim.setText("");
                nama.setText("");
                kelas.setText("");
                telpon.setText("");
                email.setText("");
                sosmed.setText("");

            }else {
                Toast.makeText(Main5Activity.this, "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
            }
        }else if (v == btnTampil){
            startActivity(new Intent(Main5Activity.this, MahasiswaActivity.class));
        }
    }
}
