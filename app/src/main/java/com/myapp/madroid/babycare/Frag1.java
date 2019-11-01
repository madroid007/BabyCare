package com.myapp.madroid.babycare;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Mad on 8/24/2017.
 */

public class Frag1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment1, container, false);

        ImageView img_weeks =(ImageView)v.findViewById(R.id.img_weeks);
        TextView txt_hi_name = (TextView)v.findViewById(R.id.txt_doct_speech_name);
        TextView txt_doc_weeks = (TextView)v.findViewById(R.id.txt_doct_speech_week);
        TextView txt_doc_days = (TextView)v.findViewById(R.id.txt_doct_speech_days);
        Typeface ssssss = Typeface.createFromAsset(getActivity().getAssets(),"shahd.ttf");
        SharedPreferences shrd = shrd = PreferenceManager.getDefaultSharedPreferences(getActivity());
        long diff ;
        int diff_days , diff_weeks , days_left , weeks_left ;
        float bmi ;
        int year = shrd.getInt("selectedYear",-1);
        int month = shrd.getInt("selectedMonth",-1);
        int day = shrd.getInt("selectedDay",-1);
        String name = shrd.getString("name","none");
        String lang = shrd.getString("language","ara");

        txt_hi_name.setTypeface(ssssss);
        txt_doc_days.setTypeface(ssssss);
        txt_doc_weeks.setTypeface(ssssss);

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

        if (weeks_left >= 0) {


            if (lang.equals("ara")) {
                txt_hi_name.setText("  اهلا  " + name);
                txt_doc_weeks.setText(String.format("انتي الآن في الاسبوع  %d", weeks_left));
                txt_doc_days.setText(String.format("باقي  %d  يوم علي الولادة ان شاء الله", diff_days));
            } else if (lang.equals("eng")) {
                txt_hi_name.setText("  Hi  " + name);
                txt_doc_weeks.setText(String.format("You are now in week %d", weeks_left));
                txt_doc_days.setText(String.format("There are %d days left to your Due date", diff_days));
            }

        }else{

            if (lang.equals("ara")) {
                txt_hi_name.setText("  اهلا  " + name);
                txt_doc_weeks.setText("تهانينا من المفترض الان انكي اصبحت ام");
            } else if (lang.equals("eng")) {
                txt_hi_name.setText("  Hi  " + name);
                txt_doc_weeks.setText("Congratulatons , you are supposed to be a mom now");
            }

        }



        switch (weeks_left){
            case 1 :
                img_weeks.setBackgroundResource(R.drawable.a1);
                break;
            case 2 :
                img_weeks.setBackgroundResource(R.drawable.a1);
                break;
            case 3 :
                img_weeks.setBackgroundResource(R.drawable.a3);
                break;
            case 4 :
                img_weeks.setBackgroundResource(R.drawable.a4);
                break;
            case 5 :
                img_weeks.setBackgroundResource(R.drawable.a5);
                break;
            case 6 :
                img_weeks.setBackgroundResource(R.drawable.a6);
                break;
            case 7 :
                img_weeks.setBackgroundResource(R.drawable.a7);
                break;
            case 8 :
                img_weeks.setBackgroundResource(R.drawable.a8);
                break;
            case 9 :
                img_weeks.setBackgroundResource(R.drawable.a9);
                break;
            case 10 :
                img_weeks.setBackgroundResource(R.drawable.a10);
                break;
            case 11 :
                img_weeks.setBackgroundResource(R.drawable.a11);
                break;
            case 12 :
                img_weeks.setBackgroundResource(R.drawable.a12);
                break;
            case 13 :
                img_weeks.setBackgroundResource(R.drawable.a13);
                break;
            case 14 :
                img_weeks.setBackgroundResource(R.drawable.a14);
                break;
            case 15 :
                img_weeks.setBackgroundResource(R.drawable.a15);
                break;
            case 16 :
                img_weeks.setBackgroundResource(R.drawable.a16);
                break;
            case 17 :
                img_weeks.setBackgroundResource(R.drawable.a17);
                break;
            case 18 :
                img_weeks.setBackgroundResource(R.drawable.a18);
                break;
            case 19 :
                img_weeks.setBackgroundResource(R.drawable.a19);
                break;
            case 20 :
                img_weeks.setBackgroundResource(R.drawable.a20);
                break;
            case 21 :
                img_weeks.setBackgroundResource(R.drawable.a21);
                break;
            case 22 :
                img_weeks.setBackgroundResource(R.drawable.a22);
                break;
            case 23 :
                img_weeks.setBackgroundResource(R.drawable.a23);
                break;
            case 24 :
                img_weeks.setBackgroundResource(R.drawable.a24);
                break;
            case 25 :
                img_weeks.setBackgroundResource(R.drawable.a25);
                break;
            case 26 :
                img_weeks.setBackgroundResource(R.drawable.a26);
                break;
            case 27 :
                img_weeks.setBackgroundResource(R.drawable.a27);
                break;
            case 28 :
                img_weeks.setBackgroundResource(R.drawable.a28);
                break;
            case 29 :
                img_weeks.setBackgroundResource(R.drawable.a29);
                break;
            case 30 :
                img_weeks.setBackgroundResource(R.drawable.a30);
                break;
            case 31 :
                img_weeks.setBackgroundResource(R.drawable.a31);
                break;
            case 32 :
                img_weeks.setBackgroundResource(R.drawable.a32);
                break;
            case 33 :
                img_weeks.setBackgroundResource(R.drawable.a33);
                break;
            case 34 :
                img_weeks.setBackgroundResource(R.drawable.a34);
                break;
            case 35 :
                img_weeks.setBackgroundResource(R.drawable.a35);
                break;
            case 36 :
                img_weeks.setBackgroundResource(R.drawable.a36);
                break;
            case 37 :
                img_weeks.setBackgroundResource(R.drawable.a37);
                break;
            case 38 :
                img_weeks.setBackgroundResource(R.drawable.a38);
                break;
            case 39 :
                img_weeks.setBackgroundResource(R.drawable.a39);
                break;
            case 40 :
                img_weeks.setBackgroundResource(R.drawable.a40);
                break;
            default: img_weeks.setImageResource(R.drawable.heartoff);

        }

        return v ;
    }


}
