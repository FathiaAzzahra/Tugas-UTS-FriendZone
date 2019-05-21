package com.example.friendzone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FriendFragment extends Fragment {
    private String[] dataName;
    private String[] dataNim;
    private String[] dataKelas;
    private String[] dataEmail;
    private String[] dataTelepon;
    private String[] dataSocial;
    private FriendAdapter adapter;
    private ArrayList<Friend> heroes;

//tanggal 18/05/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

    public FriendFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend, container, false);


        adapter = new FriendAdapter(getContext());

        ListView listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        prepare();

        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }



    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataNim = getResources().getStringArray(R.array.data_nim);
        dataKelas = getResources().getStringArray(R.array.data_kelas);
        dataEmail = getResources().getStringArray(R.array.data_email);
        dataTelepon = getResources().getStringArray(R.array.data_telepon);
        dataSocial = getResources().getStringArray(R.array.data_social);

    }

    private void addItem() {
        heroes = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Friend hero = new Friend();
            hero.setName(dataName[i]);
            hero.setNim(dataNim[i]);
            hero.setKelas(dataKelas[i]);
            hero.setTelepon(dataTelepon[i]);
            hero.setEmail(dataEmail[i]);
            hero.setSocial(dataSocial[i]);

            heroes.add(hero);
        }

        adapter.setHeroes(heroes);
    }


}
