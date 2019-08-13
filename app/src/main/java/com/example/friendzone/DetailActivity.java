package com.example.friendzone;
//tanggal 12/08/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNim, etNama, etKelas,etTelpon,etEmail,etSosmed;
    String nim, nama,kelas,telpon,email,sosmed;
    Integer id;
    Button btn_ubah, btn_hapus, btn_kembali;
    RealmHelper realmHelper;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Set up
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        // Inisialisasi
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        etKelas = findViewById(R.id.etKelas);
        etTelpon = findViewById(R.id.etTelpon);
        etEmail = findViewById(R.id.etEmail);
        etSosmed = findViewById(R.id.etSosmed);
        btn_ubah = findViewById(R.id.btnUpdate);
        btn_hapus = findViewById(R.id.btnHapus);
        btn_kembali = findViewById(R.id.btnCancel);

        id = Integer.parseInt(getIntent().getStringExtra("id"));
        nim = getIntent().getStringExtra("nim");
        nama = getIntent().getStringExtra("nama");
        kelas = getIntent().getStringExtra("kelas");
        telpon = getIntent().getStringExtra("telpon");
        email = getIntent().getStringExtra("email");
        sosmed = getIntent().getStringExtra("sosmed");

        etNim.setText(nim);
        etNama.setText(nama);
        etKelas.setText(kelas);
        etTelpon.setText(telpon);
        etEmail.setText(email);
        etSosmed.setText(sosmed);

        btn_kembali.setOnClickListener(this);
        btn_hapus.setOnClickListener(this);
        btn_ubah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_ubah){

            realmHelper.update(id,
                    Integer.parseInt(etNim.getText().toString()),
                    etNama.getText().toString(),
                    etKelas.getText().toString(),
                    etTelpon.getText().toString(),
                    etEmail.getText().toString(),
                    etSosmed.getText().toString());

            //realmHelper.update(id, Integer.parseInt(etNim.getText().toString()),etNama.getText().toString());
            Toast.makeText(DetailActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
            etNim.setText("");
            etNama.setText("");
            finish();
        }else if (v == btn_hapus) {
            realmHelper.delete(id);
            Toast.makeText(DetailActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
            finish();
        }else if (v == btn_kembali) {
            startActivity(new Intent(DetailActivity.this, MahasiswaActivity.class));
            finish();
        }
    }
}
