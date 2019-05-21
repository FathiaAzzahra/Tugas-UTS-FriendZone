package com.example.friendzone;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

//tanggal 18/05/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

public class MainActivity extends AppCompatActivity {
    ImageView bgapp;
    LinearLayout textsplash;
    RelativeLayout viewpager;
    Animation frombottom;

    private ViewPager mSlideVIewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private Button mStartButton;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        mSlideVIewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dottLayouts);
        mStartButton = (Button) findViewById(R.id.button);

        sliderAdapter = new SliderAdapter(this);
        mSlideVIewPager.setAdapter(sliderAdapter);
        addDotsIdicator(0);
        mSlideVIewPager.addOnPageChangeListener(viewListener);

        bgapp = (ImageView) findViewById(R.id.bgview);
        textsplash = (LinearLayout)findViewById(R.id.textsplash);
        viewpager = (RelativeLayout) findViewById(R.id.viewpager);

        bgapp.animate().translationY(-740).setDuration(800).setStartDelay(300);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        viewpager.startAnimation(frombottom);

        //button
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
                finish();

            }
        });
    }

    public void openActivity2()
    {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }


    public void addDotsIdicator(int position)
    {
        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0; i<mDots.length;i++)
        {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length > 0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIdicator(i);
            mCurrentPage = i;

            if(mCurrentPage == mDots.length-1)
            {
                mStartButton.setEnabled(true);
                mStartButton.setText("Start");
                mStartButton.setVisibility(View.VISIBLE);
            }
            else
            {
                mStartButton.setEnabled(false);
                mStartButton.setText("");
                mStartButton.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
