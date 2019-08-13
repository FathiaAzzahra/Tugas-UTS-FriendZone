package com.example.friendzone.view;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.friendzone.R;

//tanggal 18/05/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

public class CustomListView extends ArrayAdapter<String> {

    private String[] nama;
    private String[] nim;
    private String[] kelas;
    private String[] tlp;
    private String[] email;
    private String[] sosmed;
    private Activity context;


    public CustomListView(Activity context, String[] nama,String[] nim,String[] kelas,String[] tlp,
                            String[] email,String[] sosmed)
    {
        super(context, R.layout.listview_layout,nama);
        this.context=context;
        this.nama=nama;
        this.nim=nim;
        this.kelas=kelas;
        this.tlp=tlp;
        this.email=email;
        this.sosmed=sosmed;

    }

    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {

        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null)
        {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder) r.getTag();
        }
        viewHolder.tvwnama.setText(nama[position]);
        viewHolder.tvwnim.setText(nim[position]);
        viewHolder.tvwkelas.setText(kelas[position]);
        viewHolder.tvwtlp.setText(tlp[position]);
        viewHolder.tvwemail.setText(email[position]);
        viewHolder.tvwsosmed.setText(sosmed[position]);



        return r;
    }

    class ViewHolder
    {
        TextView tvwnama;
        TextView tvwnim;
        TextView tvwkelas;
        TextView tvwtlp;
        TextView tvwemail;
        TextView tvwsosmed;

        ViewHolder(View v)
        {
            tvwnama = v.findViewById(R.id.nama);
            tvwnim = v.findViewById(R.id.nim);
            tvwkelas = v.findViewById(R.id.kelas);
            tvwtlp = v.findViewById(R.id.tlp);
            tvwemail = v.findViewById(R.id.email);
            tvwsosmed = v.findViewById(R.id.sosmed);


        }
    }
}
