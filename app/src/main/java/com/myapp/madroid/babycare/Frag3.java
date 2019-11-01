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
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Mad on 8/24/2017.
 */

public class Frag3 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment3, container, false);

        Typeface ssssss = Typeface.createFromAsset(getActivity().getAssets(),"shahd.ttf");

        TextView txt_week = (TextView)v.findViewById(R.id.txt_me_week_num);

        txt_week.setTypeface(ssssss);

        Button btn_guide = (Button)v.findViewById(R.id.btn_guide);
        Button btn_weight = (Button)v.findViewById(R.id.btn_weight);
        Button btn_hint = (Button)v.findViewById(R.id.btn_hints);
        Button btn_changes = (Button)v.findViewById(R.id.btn_changes);

        final int [] underWeight_min = new int[40], underWeight_max = new int[40] , normalWeight_min = new int[40] , normalWeight_max = new int[40] , overWeight_min = new int[40] , overWeight_max = new int[40] , obesse_min = new int[40] , obesse_max = new int[40] ;

        String [] bmi_underWeight_min = getActivity().getResources().getStringArray(R.array.bmi_underWeight_min);
        String [] bmi_underWeight_max = getActivity().getResources().getStringArray(R.array.bmi_underWeight_max);

        String [] bmi_normalWeight_min = getActivity().getResources().getStringArray(R.array.bmi_normalWeight_min);
        String [] bmi_normalWeight_max = getActivity().getResources().getStringArray(R.array.bmi_normalWeight_max);

        String [] bmi_overWeight_min = getActivity().getResources().getStringArray(R.array.bmi_overWeight_min);
        String [] bmi_overWeight_max = getActivity().getResources().getStringArray(R.array.bmi_overWeight_max);

        String [] bmi_obesse_min = getActivity().getResources().getStringArray(R.array.bmi_obesse_min);
        String [] bmi_obesse_max = getActivity().getResources().getStringArray(R.array.bmi_obesse_max);

        for (int i =0 ; i < bmi_underWeight_min.length ; i++){

            underWeight_min[i] = Integer.parseInt(bmi_underWeight_min[i]);
            underWeight_max[i] = Integer.parseInt(bmi_underWeight_max[i]);
            normalWeight_min[i] = Integer.parseInt(bmi_normalWeight_min[i]);
            normalWeight_max[i] = Integer.parseInt(bmi_normalWeight_max[i]);
            overWeight_min[i] = Integer.parseInt(bmi_overWeight_min[i]);
            overWeight_max[i] = Integer.parseInt(bmi_overWeight_max[i]);
            obesse_min[i] = Integer.parseInt(bmi_obesse_min[i]);
            obesse_max[i] = Integer.parseInt(bmi_obesse_max[i]);




        }



        SharedPreferences shrd =shrd = PreferenceManager.getDefaultSharedPreferences(getActivity());
        long diff ;
        final int diff_days , diff_weeks , days_left , weeks_left ;
        int year = shrd.getInt("selectedYear",-1);
        int month = shrd.getInt("selectedMonth",-1);
        int day = shrd.getInt("selectedDay",-1);
        final int weight = shrd.getInt("selectedWeight",-1);
        final int[] weight_max = new int[1];
        final int[] weight_min = new int[1];
        String name = shrd.getString("name","none");
        final float bmi = shrd.getFloat("bmi", -1);


        final Calendar cal = Calendar.getInstance();
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
        weeks_left = 40 - diff_weeks;
        days_left = 280 - diff_days;

        switch (weeks_left){
            case 1 :
                txt_week.setText("Week 1");
                break;
            case 2 :
                txt_week.setText("Week 2");
                break;
            case 3 :
                txt_week.setText("Week 3");
                break;
            case 4 :
                txt_week.setText("Week 4");
                break;
            case 5 :
                txt_week.setText("Week 5");
                break;
            case 6 :
                txt_week.setText("Week 6");
                break;
            case 7 :
                txt_week.setText("Week 7");
                break;
            case 8 :
                txt_week.setText("Week 8");
                break;
            case 9 :
                txt_week.setText("Week 9");
                break;
            case 10 :
                txt_week.setText("Week 10");
                break;
            case 11 :
                txt_week.setText("Week 11");
                break;
            case 12 :
                txt_week.setText("Week 12");
                break;
            case 13 :
                txt_week.setText("Week 13");
                break;
            case 14 :
                txt_week.setText("Week 14");
                break;
            case 15 :
                txt_week.setText("Week 15");
                break;
            case 16 :
                txt_week.setText("Week 16");
                break;
            case 17 :
                txt_week.setText("Week 17");
                break;
            case 18 :
                txt_week.setText("Week 18");
                break;
            case 19 :
                txt_week.setText("Week 19");
                break;
            case 20 :
                txt_week.setText("Week 20");
                break;
            case 21 :
                txt_week.setText("Week 21");
                break;
            case 22 :
                txt_week.setText("Week 22");
                break;
            case 23 :
                txt_week.setText("Week 23");
                break;
            case 24 :
                txt_week.setText("Week 24");
                break;
            case 25 :
                txt_week.setText("Week 25");
                break;
            case 26 :
                txt_week.setText("Week 26");
                break;
            case 27 :
                txt_week.setText("Week 27");
                break;
            case 28 :
                txt_week.setText("Week 28");
                break;
            case 29 :
                txt_week.setText("Week 29");
                break;
            case 30 :
                txt_week.setText("Week 30");
                break;
            case 31 :
                txt_week.setText("Week 31");
                break;
            case 32 :
                txt_week.setText("Week 32");
                break;
            case 33 :
                txt_week.setText("Week 33");
                break;
            case 34 :
                txt_week.setText("Week 34");
                break;
            case 35 :
                txt_week.setText("Week 35");
                break;
            case 36 :
                txt_week.setText("Week 36");
                break;
            case 37 :
                txt_week.setText("Week 37");
                break;
            case 38 :
                txt_week.setText("Week 38");
                break;
            case 39 :
                txt_week.setText("Week 39");
                break;
            case 40 :
                txt_week.setText("Week 40");
                break;
            default: txt_week.setText("Congratulations");
        }


        btn_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity().getApplicationContext(),MainMainActivity.class);
                Bundle bundle =new Bundle();
                bundle.putInt("pos",1004);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        btn_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(),ScrollActivity.class);
                Bundle bundle =new Bundle();
                bundle.putInt("scroll_pos",104);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btn_changes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity().getApplicationContext(),ScrollActivity.class);
                Bundle bundle =new Bundle();
                bundle.putInt("scroll_pos",105);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btn_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity().getApplicationContext(),ScrollActivity.class);
                Bundle bundle =new Bundle();
                bundle.putInt("scroll_pos",106);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return v;
    }

}
