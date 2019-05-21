package com.example.friendzone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


//tanggal 20/05/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

public class FriendAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Friend> heroes;

    public void setHeroes(ArrayList<Friend> heroes) {
        this.heroes = heroes;
    }

    public FriendAdapter(Context context) {
        this.context = context;
        heroes = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            //Menghubungkan ViewHolder dengan View
            view = LayoutInflater.from(context).inflate(R.layout.listview_layout, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);

        //Mengubah nilai pahlawan sesuai dari posisinya
        Friend hero = (Friend) getItem(i);
        viewHolder.bind(hero);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtNim;
        private TextView txtKelas;
        private TextView txtTelepon;
        private TextView txtEmail;
        private TextView txtSocial;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.nama);
            txtNim = view.findViewById(R.id.nim);
            txtKelas = view.findViewById(R.id.kelas);
            txtTelepon = view.findViewById(R.id.tlp);
            txtEmail = view.findViewById(R.id.email);
            txtSocial = view.findViewById(R.id.sosmed);
        }

        void bind(Friend hero) {
            txtName.setText(hero.getName());
            txtNim.setText(hero.getNim());
            txtKelas.setText(hero.getKelas());
            txtTelepon.setText(hero.getTelepon());
            txtEmail.setText(hero.getEmail());
            txtSocial.setText(hero.getSocial());


        }
    }
}
