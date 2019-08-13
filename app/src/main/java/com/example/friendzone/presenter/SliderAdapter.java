package com.example.friendzone.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.friendzone.R;

//tanggal 18/05/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;



    public SliderAdapter(Context context)
    {
        this.context = context;
    }

    //Array
    public int [] slide_images = {
            R.drawable.roti,
            R.drawable.social,
            R.drawable.life
    };

    public String[] slide_text =
            {
                    "Friend Zone adalah aplikasi penghubung antara teman",
                    "Yang tidak hanya dapat menghubungi lewat no telephon tapi juga media sosial lainnya",
                    "Anda juga dapat menambahkan teman baru atau merubah data teman yang ada pada aplikasi ini atau mengahpusnya"
            };

    @Override
    public int getCount() {
        return slide_text.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = view.findViewById(R.id.slideImage);
        TextView slideTextView = view.findViewById(R.id.slideText);

        slideImageView.setImageResource(slide_images[position]);
        slideTextView.setText(slide_text[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}

