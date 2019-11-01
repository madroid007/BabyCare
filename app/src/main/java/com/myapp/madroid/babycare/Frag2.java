package com.myapp.madroid.babycare;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Mad on 8/24/2017.
 */

public class Frag2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment2, container, false);

        final String [] babySize = getActivity().getResources().getStringArray(R.array.baby_size);
        final String [] babyDevelop = getActivity().getResources().getStringArray(R.array.baby_development);
        final String [] babySonar = getActivity().getResources().getStringArray(R.array.sonar);


        TextView txt = (TextView)v.findViewById(R.id.txt_babymain);

        Button btn_develop = (Button)v.findViewById(R.id.btn_baby1);
        Button btn_sonar = (Button)v.findViewById(R.id.btn_baby2);
        Button btn3 = (Button)v.findViewById(R.id.btn_baby3);

        ImageView img = (ImageView)v.findViewById(R.id.img_babymain);

        Typeface ssssss = Typeface.createFromAsset(getActivity().getAssets(),"shahd.ttf");
        SharedPreferences shrd =shrd = PreferenceManager.getDefaultSharedPreferences(getActivity());

        btn_develop.setTypeface(ssssss);
        btn_sonar.setTypeface(ssssss);
        btn3.setTypeface(ssssss);
        txt.setTypeface(ssssss);

        long diff ;
        final int diff_days , diff_weeks , days_left , weeks_left ;
        float bmi ;
        int year = shrd.getInt("selectedYear",-1);
        int month = shrd.getInt("selectedMonth",-1);
        int day = shrd.getInt("selectedDay",-1);
        String name = shrd.getString("name","none");
        String lang = shrd.getString("language","ara");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_MONTH, day);
        switch (month) {
            case 1:
                cal.set(Calendar.MONTH, Calendar.JANUARY);
                break;
            case 2:
                cal.set(Calendar.MONTH, Calendar.FEBRUARY);
                break;
            case 3:
                cal.set(Calendar.MONTH, Calendar.MARCH);
                break;
            case 4:
                cal.set(Calendar.MONTH, Calendar.APRIL);
                break;
            case 5:
                cal.set(Calendar.MONTH, Calendar.MAY);
                break;
            case 6:
                cal.set(Calendar.MONTH, Calendar.JUNE);
                break;
            case 7:
                cal.set(Calendar.MONTH, Calendar.JULY);
                break;
            case 8:
                cal.set(Calendar.MONTH, Calendar.AUGUST);
                break;
            case 9:
                cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
                break;
            case 10:
                cal.set(Calendar.MONTH, Calendar.OCTOBER);
                break;
            case 11:
                cal.set(Calendar.MONTH, Calendar.NOVEMBER);
                break;
            case 12:
                cal.set(Calendar.MONTH, Calendar.DECEMBER);
                break;
        }
        Calendar today = Calendar.getInstance();

        diff = cal.getTimeInMillis() - today.getTimeInMillis();
        diff_days = (int) (diff / (1000 * 60 * 60 * 24));
        diff_weeks = (int) (diff / (7 * 1000 * 60 * 60 * 24));
        bmi = shrd.getFloat("bmi", -1);
        weeks_left = 40 - diff_weeks;
        days_left = 280 - diff_days;

        if (lang == "ara"){
            txt.setText(String.format("طفلك الآن في الاسبوع %d",weeks_left));
        }else if (lang == "eng"){
            txt.setText(String.format("Your baby is in Week %d",weeks_left));
        }


        switch (weeks_left){
            case 1 :
                img.setBackgroundResource(R.drawable.b2);
                break;
            case 2 :
                img.setBackgroundResource(R.drawable.b2);
                break;
            case 3 :
                img.setBackgroundResource(R.drawable.b3);
                break;
            case 4 :
                img.setBackgroundResource(R.drawable.b4);
                break;
            case 5 :
                img.setBackgroundResource(R.drawable.b5);
                break;
            case 6 :
                img.setBackgroundResource(R.drawable.b6);
                break;
            case 7 :
                img.setBackgroundResource(R.drawable.b7);
                break;
            case 8 :
                img.setBackgroundResource(R.drawable.b8);
                break;
            case 9 :
                img.setBackgroundResource(R.drawable.b9);
                break;
            case 10 :
                img.setBackgroundResource(R.drawable.b10);
                break;
            case 11 :
                img.setBackgroundResource(R.drawable.b11);
                break;
            case 12 :
                img.setBackgroundResource(R.drawable.b12);
                break;
            case 13 :
                img.setBackgroundResource(R.drawable.b13);
                break;
            case 14 :
                img.setBackgroundResource(R.drawable.b14);
                break;
            case 15 :
                img.setBackgroundResource(R.drawable.b15);
                break;
            case 16 :
                img.setBackgroundResource(R.drawable.b16);
                break;
            case 17 :
                img.setBackgroundResource(R.drawable.b17);
                break;
            case 18 :
                img.setBackgroundResource(R.drawable.b18);
                break;
            case 19 :
                img.setBackgroundResource(R.drawable.b19);
                break;
            case 20 :
                img.setBackgroundResource(R.drawable.b20);
                break;
            case 21 :
                img.setBackgroundResource(R.drawable.b21);
                break;
            case 22 :
                img.setBackgroundResource(R.drawable.b22);
                break;
            case 23 :
                img.setBackgroundResource(R.drawable.b23);
                break;
            case 24 :
                img.setBackgroundResource(R.drawable.b24);
                break;
            case 25 :
                img.setBackgroundResource(R.drawable.b25);
                break;
            case 26 :
                img.setBackgroundResource(R.drawable.b26);
                break;
            case 27 :
                img.setBackgroundResource(R.drawable.b27);
                break;
            case 28 :
                img.setBackgroundResource(R.drawable.b28);
                break;
            case 29 :
                img.setBackgroundResource(R.drawable.b29);
                break;
            case 30 :
                img.setBackgroundResource(R.drawable.b30);
                break;
            case 31 :
                img.setBackgroundResource(R.drawable.b31);
                break;
            case 32 :
                img.setBackgroundResource(R.drawable.b32);
                break;
            case 33 :
                img.setBackgroundResource(R.drawable.b33);
                break;
            case 34 :
                img.setBackgroundResource(R.drawable.b34);
                break;
            case 35 :
                img.setBackgroundResource(R.drawable.b35);
                break;
            case 36 :
                img.setBackgroundResource(R.drawable.b36);
                break;
            case 37 :
                img.setBackgroundResource(R.drawable.b37);
                break;
            case 38 :
                img.setBackgroundResource(R.drawable.b38);
                break;
            case 39 :
                img.setBackgroundResource(R.drawable.b39);
                break;
            case 40 :
                img.setBackgroundResource(R.drawable.b40);
                break;
            default: img.setImageResource(R.drawable.heartoff);
        }

        btn_develop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity().getApplicationContext(),ScrollActivity.class);
                Bundle bundle =new Bundle();
                bundle.putInt("scroll_pos",101);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btn_sonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity().getApplicationContext(),ScrollActivity.class);
                Bundle bundle =new Bundle();
                bundle.putInt("scroll_pos",102);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity().getApplicationContext(),ScrollActivity.class);
                Bundle bundle =new Bundle();
                bundle.putInt("scroll_pos",103);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        //Inflate the layout for this fragment

        return v;
    }


}
