package com.myapp.madroid.babycare;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.NativeExpressAdView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainMainActivity extends AppCompatActivity {
    Typeface ssssss ;
    SharedPreferences shrd ;
    Bundle bundle ;
    int position ;
    ImageView img_baby_layout , img_baby_arrow ;
    TextView txt_baby_layout ,txt_baby_layout1 , txt_weight , txt_baby_layout3 , txt_baby_min , txt_baby_max ;
    int [] bmi_min = new int[40] , bmi_max =new int[40] ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        NativeExpressAdView adView2 = (NativeExpressAdView)findViewById(R.id.adView2);

        AdRequest request = new AdRequest.Builder().build();
        adView2.loadAd(request);

        img_baby_layout = (ImageView)findViewById(R.id.img_layout_baby);
        txt_baby_layout = (TextView) findViewById(R.id.txt_layout_baby);
        txt_baby_layout1 = (TextView) findViewById(R.id.txt_babylayout_1);
        txt_weight = (TextView) findViewById(R.id.txt_babylayout_2);
        txt_baby_layout3 = (TextView) findViewById(R.id.txt_babylayout_3);
        txt_baby_min = (TextView) findViewById(R.id.txt_babylayout_weight_min);
        txt_baby_max = (TextView) findViewById(R.id.txt_babylayout_weight_max);
        img_baby_arrow = (ImageView) findViewById(R.id.img_layout_baby2);

        ssssss = Typeface.createFromAsset(getAssets(),"shahd.ttf");
        shrd = PreferenceManager.getDefaultSharedPreferences(this);

        String language = shrd.getString("language","ara");

        long diff ;
        final int diff_days , diff_weeks , days_left , weeks_left ;
        int year = shrd.getInt("selectedYear",-1);
        int month = shrd.getInt("selectedMonth",-1);
        int day = shrd.getInt("selectedDay",-1);
        String name = shrd.getString("name","none");
        final int weight = shrd.getInt("selectedWeight",-1);
        final int[] weight_max = new int[1];
        final int[] weight_min = new int[1];
        final float bmi = shrd.getFloat("bmi", -1);



        /********************************************************************************************/

        final int [] underWeight_min = new int[40], underWeight_max = new int[40] , normalWeight_min = new int[40] , normalWeight_max = new int[40] , overWeight_min = new int[40] , overWeight_max = new int[40] , obesse_min = new int[40] , obesse_max = new int[40] ;

        String [] bmi_underWeight_min = getResources().getStringArray(R.array.bmi_underWeight_min);
        String [] bmi_underWeight_max = getResources().getStringArray(R.array.bmi_underWeight_max);

        String [] bmi_normalWeight_min = getResources().getStringArray(R.array.bmi_normalWeight_min);
        String [] bmi_normalWeight_max = getResources().getStringArray(R.array.bmi_normalWeight_max);

        String [] bmi_overWeight_min = getResources().getStringArray(R.array.bmi_overWeight_min);
        String [] bmi_overWeight_max = getResources().getStringArray(R.array.bmi_overWeight_max);

        String [] bmi_obesse_min = getResources().getStringArray(R.array.bmi_obesse_min);
        String [] bmi_obesse_max = getResources().getStringArray(R.array.bmi_obesse_max);

        if (bmi < 18.5) {
            for (int i =0 ; i < bmi_underWeight_min.length ; i++){
                bmi_min[i] = Integer.parseInt(bmi_underWeight_min[i]);
                bmi_max[i] = Integer.parseInt(bmi_underWeight_max[i]);
                img_baby_layout.setBackgroundResource(R.drawable.bmi_underweight);
            }

        } else if (bmi > 18.5 && bmi < 25) {
            for (int i =0 ; i < bmi_underWeight_min.length ; i++){
                bmi_min[i] = Integer.parseInt(bmi_normalWeight_min[i]);
                bmi_max[i] = Integer.parseInt(bmi_normalWeight_max[i]);
                img_baby_layout.setBackgroundResource(R.drawable.bmi_normalweight);
            }

        } else if (bmi >= 25 && bmi < 30) {
            for (int i =0 ; i < bmi_underWeight_min.length ; i++){
                bmi_min[i] = Integer.parseInt(bmi_overWeight_min[i]);
                bmi_max[i] = Integer.parseInt(bmi_overWeight_max[i]);
                img_baby_layout.setBackgroundResource(R.drawable.bmi_overweight);
            }

        } else if (bmi >= 30) {
            for (int i =0 ; i < bmi_underWeight_min.length ; i++){
                bmi_min[i] = Integer.parseInt(bmi_obesse_min[i]);
                bmi_max[i] = Integer.parseInt(bmi_obesse_max[i]);
                img_baby_layout.setBackgroundResource(R.drawable.bmi_obesse);
            }

        }

        if (language.equals("eng")){

            txt_baby_layout1.setText("weight before pregnancy");
            txt_weight.setText(weight+"");
            txt_baby_layout3.setText("Your weight should be in this range");

        }else{

            txt_baby_layout1.setText(" الوزن قبل الحمل ");
            txt_weight.setText(weight + "");
            txt_baby_layout3.setText("وزنك الآن يجب ان يتراوح بين");
        }

        /*********************************************************************************************/


        /********************************************************************************************/




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
        weeks_left = 40 - diff_weeks;
        days_left = 280 - diff_days;


        /******************************************************************************************/


        /*****************************Show Screen *************************************************/
        /***baby develop -> 1001 , baby sonar -> 1002 , baby size 1003 , mother weight ->1004********/



        bundle =getIntent().getExtras();
        position = bundle.getInt("pos",-1);

        if(language.equals("eng")) {

                switch (weeks_left){
                    case 1 :
                        weight_min[0] = weight + bmi_min[0];
                        weight_max[0] = weight + bmi_max[0];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 2 :
                        weight_min[0] = weight + bmi_min[1];
                        weight_max[0] = weight + bmi_max[1];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 3 :
                        weight_min[0] = weight + bmi_min[2];
                        weight_max[0] = weight + bmi_max[2];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 4 :
                        weight_min[0] = weight + bmi_min[3];
                        weight_max[0] = weight + bmi_max[3];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 5 :
                        weight_min[0] = weight + bmi_min[4];
                        weight_max[0] = weight + bmi_max[4];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 6 :
                        weight_min[0] = weight + bmi_min[5];
                        weight_max[0] = weight + bmi_max[5];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 7 :
                        weight_min[0] = weight + bmi_min[6];
                        weight_max[0] = weight + bmi_max[6];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 8 :
                        weight_min[0] = weight + bmi_min[7];
                        weight_max[0] = weight + bmi_max[7];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 9 :
                        weight_min[0] = weight + bmi_min[8];
                        weight_max[0] = weight + bmi_max[8];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 10 :
                        weight_min[0] = weight + bmi_min[9];
                        weight_max[0] = weight + bmi_max[9];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 11 :
                        weight_min[0] = weight + bmi_min[10];
                        weight_max[0] = weight + bmi_max[10];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 12 :
                        weight_min[0] = weight + bmi_min[11];
                        weight_max[0] = weight + bmi_max[11];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 13 :
                        weight_min[0] = weight + bmi_min[12];
                        weight_max[0] = weight + bmi_max[12];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 14 :
                        weight_min[0] = weight + bmi_min[13];
                        weight_max[0] = weight + bmi_max[13];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 15 :
                        weight_min[0] = weight + bmi_min[14];
                        weight_max[0] = weight + bmi_max[14];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 16 :
                        weight_min[0] = weight + bmi_min[15];
                        weight_max[0] = weight + bmi_max[15];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 17 :
                        weight_min[0] = weight + bmi_min[16];
                        weight_max[0] = weight + bmi_max[16];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 18 :
                        weight_min[0] = weight + bmi_min[17];
                        weight_max[0] = weight + bmi_max[17];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 19 :
                        weight_min[0] = weight + bmi_min[18];
                        weight_max[0] = weight + bmi_max[18];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 20 :
                        weight_min[0] = weight + bmi_min[19];
                        weight_max[0] = weight + bmi_max[19];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 21 :
                        weight_min[0] = weight + bmi_min[20];
                        weight_max[0] = weight + bmi_max[20];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 22 :
                        weight_min[0] = weight + bmi_min[21];
                        weight_max[0] = weight + bmi_max[21];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 23 :
                        weight_min[0] = weight + bmi_min[22];
                        weight_max[0] = weight + bmi_max[22];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 24 :
                        weight_min[0] = weight + bmi_min[23];
                        weight_max[0] = weight + bmi_max[23];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 25 :
                        weight_min[0] = weight + bmi_min[24];
                        weight_max[0] = weight + bmi_max[24];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 26 :
                        weight_min[0] = weight + bmi_min[25];
                        weight_max[0] = weight + bmi_max[25];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 27 :
                        weight_min[0] = weight + bmi_min[26];
                        weight_max[0] = weight + bmi_max[26];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 28 :
                        weight_min[0] = weight + bmi_min[27];
                        weight_max[0] = weight + bmi_max[27];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 29 :
                        weight_min[0] = weight + bmi_min[28];
                        weight_max[0] = weight + bmi_max[28];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 30 :
                        weight_min[0] = weight + bmi_min[29];
                        weight_max[0] = weight + bmi_max[29];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 31 :
                        weight_min[0] = weight + bmi_min[30];
                        weight_max[0] = weight + bmi_max[30];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 32 :
                        weight_min[0] = weight + bmi_min[31];
                        weight_max[0] = weight + bmi_max[31];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 33 :
                        weight_min[0] = weight + bmi_min[32];
                        weight_max[0] = weight + bmi_max[32];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 34 :
                        weight_min[0] = weight + bmi_min[33];
                        weight_max[0] = weight + bmi_max[33];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 35 :
                        weight_min[0] = weight + bmi_min[34];
                        weight_max[0] = weight + bmi_max[34];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 36 :
                        weight_min[0] = weight + bmi_min[35];
                        weight_max[0] = weight + bmi_max[35];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 37 :
                        weight_min[0] = weight + bmi_min[36];
                        weight_max[0] = weight + bmi_max[36];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 38 :
                        weight_min[0] = weight + bmi_min[37];
                        weight_max[0] = weight + bmi_max[37];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 39 :
                        weight_min[0] = weight + bmi_min[38];
                        weight_max[0] = weight + bmi_max[38];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                    case 40 :
                        weight_min[0] = weight + bmi_min[39];
                        weight_max[0] = weight + bmi_max[39];
                        txt_baby_layout.setText(String.format("week %d",weeks_left));
                        txt_baby_max.setText(weight_max[0]+"");
                        txt_baby_min.setText(weight_min[0]+"");
                        break;
                }
        }else{


            switch (weeks_left){


                case 1:
                    weight_min[0] = weight + bmi_min[0];
                    weight_max[0] = weight + bmi_max[0];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 2:
                    weight_min[0] = weight + bmi_min[1];
                    weight_max[0] = weight + bmi_max[1];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 3:
                    weight_min[0] = weight + bmi_min[2];
                    weight_max[0] = weight + bmi_max[2];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 4:
                    weight_min[0] = weight + bmi_min[3];
                    weight_max[0] = weight + bmi_max[3];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 5:
                    weight_min[0] = weight + bmi_min[4];
                    weight_max[0] = weight + bmi_max[4];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 6:
                    weight_min[0] = weight + bmi_min[5];
                    weight_max[0] = weight + bmi_max[5];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 7:
                    weight_min[0] = weight + bmi_min[6];
                    weight_max[0] = weight + bmi_max[6];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 8:
                    weight_min[0] = weight + bmi_min[7];
                    weight_max[0] = weight + bmi_max[7];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 9:
                    weight_min[0] = weight + bmi_min[8];
                    weight_max[0] = weight + bmi_max[8];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 10:
                    weight_min[0] = weight + bmi_min[9];
                    weight_max[0] = weight + bmi_max[9];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 11:
                    weight_min[0] = weight + bmi_min[10];
                    weight_max[0] = weight + bmi_max[10];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 12:
                    weight_min[0] = weight + bmi_min[11];
                    weight_max[0] = weight + bmi_max[11];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 13:
                    weight_min[0] = weight + bmi_min[12];
                    weight_max[0] = weight + bmi_max[12];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 14:
                    weight_min[0] = weight + bmi_min[13];
                    weight_max[0] = weight + bmi_max[13];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 15:
                    weight_min[0] = weight + bmi_min[14];
                    weight_max[0] = weight + bmi_max[14];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 16:
                    weight_min[0] = weight + bmi_min[15];
                    weight_max[0] = weight + bmi_max[15];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 17:
                    weight_min[0] = weight + bmi_min[16];
                    weight_max[0] = weight + bmi_max[16];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 18:
                    weight_min[0] = weight + bmi_min[17];
                    weight_max[0] = weight + bmi_max[17];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 19:
                    weight_min[0] = weight + bmi_min[18];
                    weight_max[0] = weight + bmi_max[18];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 20:
                    weight_min[0] = weight + bmi_min[19];
                    weight_max[0] = weight + bmi_max[19];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 21:
                    weight_min[0] = weight + bmi_min[20];
                    weight_max[0] = weight + bmi_max[20];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 22:
                    weight_min[0] = weight + bmi_min[21];
                    weight_max[0] = weight + bmi_max[21];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 23:
                    weight_min[0] = weight + bmi_min[22];
                    weight_max[0] = weight + bmi_max[22];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 24:
                    weight_min[0] = weight + bmi_min[23];
                    weight_max[0] = weight + bmi_max[23];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 25:
                    weight_min[0] = weight + bmi_min[24];
                    weight_max[0] = weight + bmi_max[24];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 26:
                    weight_min[0] = weight + bmi_min[25];
                    weight_max[0] = weight + bmi_max[25];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 27:
                    weight_min[0] = weight + bmi_min[26];
                    weight_max[0] = weight + bmi_max[26];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 28:
                    weight_min[0] = weight + bmi_min[27];
                    weight_max[0] = weight + bmi_max[27];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 29:
                    weight_min[0] = weight + bmi_min[28];
                    weight_max[0] = weight + bmi_max[28];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 30:
                    weight_min[0] = weight + bmi_min[29];
                    weight_max[0] = weight + bmi_max[29];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 31:
                    weight_min[0] = weight + bmi_min[30];
                    weight_max[0] = weight + bmi_max[30];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 32:
                    weight_min[0] = weight + bmi_min[31];
                    weight_max[0] = weight + bmi_max[31];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 33:
                    weight_min[0] = weight + bmi_min[32];
                    weight_max[0] = weight + bmi_max[32];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 34:
                    weight_min[0] = weight + bmi_min[33];
                    weight_max[0] = weight + bmi_max[33];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 35:
                    weight_min[0] = weight + bmi_min[34];
                    weight_max[0] = weight + bmi_max[34];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 36:
                    weight_min[0] = weight + bmi_min[35];
                    weight_max[0] = weight + bmi_max[35];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 37:
                    weight_min[0] = weight + bmi_min[36];
                    weight_max[0] = weight + bmi_max[36];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 38:
                    weight_min[0] = weight + bmi_min[37];
                    weight_max[0] = weight + bmi_max[37];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 39:
                    weight_min[0] = weight + bmi_min[38];
                    weight_max[0] = weight + bmi_max[38];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;
                case 40:
                    weight_min[0] = weight + bmi_min[39];
                    weight_max[0] = weight + bmi_max[39];
                    txt_baby_layout.setText(String.format("الاسبوع  %d", weeks_left));
                    txt_baby_max.setText(weight_max[0] + "");
                    txt_baby_min.setText(weight_min[0] + "");
                    break;

            }


            }
        }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
