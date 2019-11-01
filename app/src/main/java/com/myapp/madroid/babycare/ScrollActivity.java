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

public class ScrollActivity extends AppCompatActivity {


    TextView txt_scroll ;
    Typeface ssssss ;
    SharedPreferences shrd ;
    Bundle bundle ;
    int scroll_pos ;
    ImageView img_scroll ;
    String language ;
    String []babyDevelop ,babySonar , babySize ,mother_changes , tips , guide ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);


        NativeExpressAdView adView2 = (NativeExpressAdView)findViewById(R.id.adView2);

        AdRequest request = new AdRequest.Builder().build();
        adView2.loadAd(request);




        shrd = PreferenceManager.getDefaultSharedPreferences(this);
        language=shrd.getString("language","ara");


        txt_scroll = (TextView)findViewById(R.id.txt_scroll);
        img_scroll = (ImageView)findViewById(R.id.img_scroll);

        if (language.equals("eng")){

            babySize = getResources().getStringArray(R.array.baby_size_eng);
            babyDevelop = getResources().getStringArray(R.array.baby_develop_eng);
            babySonar = getResources().getStringArray(R.array.baby_sonar_eng);

            guide = getResources().getStringArray(R.array.guide_eng);
            mother_changes = getResources().getStringArray(R.array.changes_eng);
            tips = getResources().getStringArray(R.array.baby_tips_eng);

        }else{

            babySize = getResources().getStringArray(R.array.baby_size);
            babyDevelop = getResources().getStringArray(R.array.baby_development);
            babySonar = getResources().getStringArray(R.array.sonar);

            guide = getResources().getStringArray(R.array.guide_ara);
            mother_changes = getResources().getStringArray(R.array.changes);
            tips = getResources().getStringArray(R.array.hints);


        }

        /***************************************************************************************/
        ssssss = Typeface.createFromAsset(getAssets(),"shahd.ttf");
        txt_scroll.setTypeface(ssssss);

        long diff ;
        final int diff_days , diff_weeks , days_left , weeks_left ;
        int year = shrd.getInt("selectedYear",-1);
        int month = shrd.getInt("selectedMonth",-1);
        int day = shrd.getInt("selectedDay",-1);
        String name = shrd.getString("name","none");

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
        final float bmi = shrd.getFloat("bmi", -1);
        weeks_left = 40 - diff_weeks;
        days_left = 280 - diff_days;

        /***************************************************************************************/

        /***************************************************************************************/
        /*****scroll_pos , 101 -> guide , 102 -> mother changes , 103 -> tips*******************/
        bundle =getIntent().getExtras();
        scroll_pos = bundle.getInt("scroll_pos",-1);
        if (scroll_pos != -1){
            if(scroll_pos == 101){
                switch (weeks_left) {
                    case 1:
                        txt_scroll.setText(babyDevelop[0]);
                        break;
                    case 2:
                        txt_scroll.setText(babyDevelop[1]);
                        break;
                    case 3:
                        txt_scroll.setText(babyDevelop[2]);
                        break;
                    case 4:
                        txt_scroll.setText(babyDevelop[3]);
                        break;
                    case 5:
                        txt_scroll.setText(babyDevelop[4]);
                        break;
                    case 6:
                        txt_scroll.setText(babyDevelop[5]);
                        break;
                    case 7:
                        txt_scroll.setText(babyDevelop[6]);
                        break;
                    case 8:
                        txt_scroll.setText(babyDevelop[7]);
                        break;
                    case 9:
                        txt_scroll.setText(babyDevelop[8]);
                        break;
                    case 10:
                        txt_scroll.setText(babyDevelop[9]);
                        break;
                    case 11:
                        txt_scroll.setText(babyDevelop[10]);
                        break;
                    case 12:
                        txt_scroll.setText(babyDevelop[11]);
                        break;
                    case 13:
                        txt_scroll.setText(babyDevelop[12]);
                        break;
                    case 14:
                        txt_scroll.setText(babyDevelop[13]);
                        break;
                    case 15:
                        txt_scroll.setText(babyDevelop[14]);
                        break;
                    case 16:
                        txt_scroll.setText(babyDevelop[15]);
                        break;
                    case 17:
                        txt_scroll.setText(babyDevelop[16]);
                        break;
                    case 18:
                        txt_scroll.setText(babyDevelop[17]);
                        break;
                    case 19:
                        txt_scroll.setText(babyDevelop[18]);
                        break;
                    case 20:
                        txt_scroll.setText(babyDevelop[19]);
                        break;
                    case 21:
                        txt_scroll.setText(babyDevelop[20]);
                        break;
                    case 22:
                        txt_scroll.setText(babyDevelop[21]);
                        break;
                    case 23:
                        txt_scroll.setText(babyDevelop[22]);
                        break;
                    case 24:
                        txt_scroll.setText(babyDevelop[23]);
                        break;
                    case 25:
                        txt_scroll.setText(babyDevelop[24]);
                        break;
                    case 26:
                        txt_scroll.setText(babyDevelop[25]);
                        break;
                    case 27:
                        txt_scroll.setText(babyDevelop[26]);
                        break;
                    case 28:
                        txt_scroll.setText(babyDevelop[27]);
                        break;
                    case 29:
                        txt_scroll.setText(babyDevelop[28]);
                        break;
                    case 30:
                        txt_scroll.setText(babyDevelop[29]);
                        break;
                    case 31:
                        txt_scroll.setText(babyDevelop[30]);
                        break;
                    case 32:
                        txt_scroll.setText(babyDevelop[31]);
                        break;
                    case 33:
                        txt_scroll.setText(babyDevelop[32]);
                        break;
                    case 34:
                        txt_scroll.setText(babyDevelop[33]);
                        break;
                    case 35:
                        txt_scroll.setText(babyDevelop[34]);
                        break;
                    case 36:
                        txt_scroll.setText(babyDevelop[35]);
                        break;
                    case 37:
                        txt_scroll.setText(babyDevelop[36]);
                        break;
                    case 38:
                        txt_scroll.setText(babyDevelop[37]);
                        break;
                    case 39:
                        txt_scroll.setText(babyDevelop[38]);
                        break;
                    case 40:
                        txt_scroll.setText(babyDevelop[39]);
                        break;
                    default: txt_scroll.setText("Congratulations");
                }

            }else if (scroll_pos == 102){
                switch (weeks_left){
                    case 1:
                        txt_scroll.setText(babySonar[1]);
                        break;
                    case 2:
                        txt_scroll.setText(babySonar[2]);
                        break;
                    case 3:
                        txt_scroll.setText(babySonar[3]);
                        break;
                    case 4:
                        img_scroll.setBackgroundResource(R.drawable.sonar4);
                        txt_scroll.setText(babySonar[4]);
                        break;
                    case 5:
                        img_scroll.setBackgroundResource(R.drawable.sonar5);
                        txt_scroll.setText(babySonar[5]);
                        break;
                    case 6:
                        img_scroll.setBackgroundResource(R.drawable.sonar6);
                        txt_scroll.setText(babySonar[6]);
                        break;
                    case 7:
                        img_scroll.setBackgroundResource(R.drawable.sonar7);
                        txt_scroll.setText(babySonar[7]);
                        break;
                    case 8:
                        img_scroll.setBackgroundResource(R.drawable.sonar8);
                        txt_scroll.setText(babySonar[8]);
                        break;
                    case 9:
                        img_scroll.setBackgroundResource(R.drawable.sonar9);
                        txt_scroll.setText(babySonar[9]);
                        break;
                    case 10:
                        img_scroll.setBackgroundResource(R.drawable.sonar10);
                        txt_scroll.setText(babySonar[10]);
                        break;
                    case 11:
                        img_scroll.setBackgroundResource(R.drawable.sonar11);
                        txt_scroll.setText(babySonar[11]);
                        break;
                    case 12:
                        img_scroll.setBackgroundResource(R.drawable.sonar12);
                        txt_scroll.setText(babySonar[12]);
                        break;
                    case 13:
                        img_scroll.setBackgroundResource(R.drawable.sonar13);
                        txt_scroll.setText(babySonar[13]);
                        break;
                    case 14:
                        img_scroll.setBackgroundResource(R.drawable.sonar14);
                        txt_scroll.setText(babySonar[14]);
                        break;
                    case 15:
                        img_scroll.setBackgroundResource(R.drawable.sonar15);
                        txt_scroll.setText(babySonar[15]);
                        break;
                    case 16:
                        img_scroll.setBackgroundResource(R.drawable.sonar16);
                        txt_scroll.setText(babySonar[16]);
                        break;
                    case 17:
                        img_scroll.setBackgroundResource(R.drawable.sonar17);
                        txt_scroll.setText(babySonar[17]);
                        break;
                    case 18:
                        img_scroll.setBackgroundResource(R.drawable.sonar18);
                        txt_scroll.setText(babySonar[18]);
                        break;
                    case 19:
                        img_scroll.setBackgroundResource(R.drawable.sonar19);
                        txt_scroll.setText(babySonar[19]);
                        break;
                    case 20:
                        img_scroll.setBackgroundResource(R.drawable.sonar20);
                        txt_scroll.setText(babySonar[20]);
                        break;
                    case 21:
                        img_scroll.setBackgroundResource(R.drawable.sonar21);
                        txt_scroll.setText(babySonar[21]);
                        break;
                    case 22:
                        img_scroll.setBackgroundResource(R.drawable.sonar22);
                        txt_scroll.setText(babySonar[22]);
                        break;
                    case 23:
                        img_scroll.setBackgroundResource(R.drawable.sonar23);
                        txt_scroll.setText(babySonar[23]);
                        break;
                    case 24:
                        img_scroll.setBackgroundResource(R.drawable.sonar24);
                        txt_scroll.setText(babySonar[24]);
                        break;
                    case 25:
                        img_scroll.setBackgroundResource(R.drawable.sonar25);
                        txt_scroll.setText(babySonar[25]);
                        break;
                    case 26:
                        img_scroll.setBackgroundResource(R.drawable.sonar26);
                        txt_scroll.setText(babySonar[26]);
                        break;
                    case 27:
                        img_scroll.setBackgroundResource(R.drawable.sonar27);
                        txt_scroll.setText(babySonar[27]);
                        break;
                    case 28:
                        img_scroll.setBackgroundResource(R.drawable.sonar28);
                        txt_scroll.setText(babySonar[28]);
                        break;
                    case 29:
                        img_scroll.setBackgroundResource(R.drawable.sonar29);
                        txt_scroll.setText(babySonar[29]);
                        break;
                    case 30:
                        img_scroll.setBackgroundResource(R.drawable.sonar30);
                        txt_scroll.setText(babySonar[30]);
                        break;
                    case 31:
                        img_scroll.setBackgroundResource(R.drawable.sonar31);
                        txt_scroll.setText(babySonar[31]);
                        break;
                    case 32:
                        img_scroll.setBackgroundResource(R.drawable.sonar32);
                        txt_scroll.setText(babySonar[32]);
                        break;
                    case 33:
                        img_scroll.setBackgroundResource(R.drawable.sonar33);
                        txt_scroll.setText(babySonar[33]);
                        break;
                    case 34:
                        img_scroll.setBackgroundResource(R.drawable.sonar34);
                        txt_scroll.setText(babySonar[34]);
                        break;
                    case 35:
                        img_scroll.setBackgroundResource(R.drawable.sonar35);
                        txt_scroll.setText(babySonar[35]);
                        break;
                    case 36:
                        img_scroll.setBackgroundResource(R.drawable.sonar36);
                        txt_scroll.setText(babySonar[36]);
                        break;
                    case 37:
                        img_scroll.setBackgroundResource(R.drawable.sonar37);
                        txt_scroll.setText(babySonar[37]);
                        break;
                    case 38:
                        img_scroll.setBackgroundResource(R.drawable.sonar38);
                        txt_scroll.setText(babySonar[38]);
                        break;
                    case 39:
                        img_scroll.setBackgroundResource(R.drawable.sonar39);
                        txt_scroll.setText(babySonar[39]);
                        break;
                    case 40:
                        img_scroll.setBackgroundResource(R.drawable.sonar40);
                        txt_scroll.setText(babySonar[40]);
                        break;
                    default:
                        img_scroll.setBackgroundResource(R.drawable.heartoff);
                        txt_scroll.setText("Congratulations");
                }

            }else if (scroll_pos == 103){
                switch (weeks_left){
                    case 1 :
                        txt_scroll.setText(babySize[0]);
                        break;
                    case 2 :
                        txt_scroll.setText(babySize[1]);
                        break;
                    case 3 :
                        txt_scroll.setText(babySize[2]);
                        break;
                    case 4 :
                        img_scroll.setBackgroundResource(R.drawable.bs4);
                        txt_scroll.setText(babySize[3]);
                        break;
                    case 5 :
                        img_scroll.setBackgroundResource(R.drawable.bs5);
                        txt_scroll.setText(babySize[4]);
                        break;
                    case 6 :
                        img_scroll.setBackgroundResource(R.drawable.bs6);
                        txt_scroll.setText(babySize[5]);
                        break;
                    case 7 :
                        img_scroll.setBackgroundResource(R.drawable.bs7);
                        txt_scroll.setText(babySize[6]);
                        break;
                    case 8 :
                        img_scroll.setBackgroundResource(R.drawable.bs8);
                        txt_scroll.setText(babySize[7]);
                        break;
                    case 9 :
                        img_scroll.setBackgroundResource(R.drawable.bs9);
                        txt_scroll.setText(babySize[8]);
                        break;
                    case 10 :
                        img_scroll.setBackgroundResource(R.drawable.bs10);
                        txt_scroll.setText(babySize[9]);
                        break;
                    case 11 :
                        img_scroll.setBackgroundResource(R.drawable.bs11);
                        txt_scroll.setText(babySize[10]);
                        break;
                    case 12 :
                        img_scroll.setBackgroundResource(R.drawable.bs12);
                        txt_scroll.setText(babySize[11]);
                        break;
                    case 13 :
                        img_scroll.setBackgroundResource(R.drawable.bs13);
                        txt_scroll.setText(babySize[12]);
                        break;
                    case 14 :
                        img_scroll.setBackgroundResource(R.drawable.bs14);
                        txt_scroll.setText(babySize[13]);
                        break;
                    case 15 :
                        img_scroll.setBackgroundResource(R.drawable.bs15);
                        txt_scroll.setText(babySize[14]);
                        break;
                    case 16 :
                        img_scroll.setBackgroundResource(R.drawable.bs16);
                        txt_scroll.setText(babySize[15]);
                        break;
                    case 17 :
                        img_scroll.setBackgroundResource(R.drawable.bs17);
                        txt_scroll.setText(babySize[16]);
                        break;
                    case 18 :
                        img_scroll.setBackgroundResource(R.drawable.bs18);
                        txt_scroll.setText(babySize[17]);
                        break;
                    case 19 :
                        img_scroll.setBackgroundResource(R.drawable.bs19);
                        txt_scroll.setText(babySize[18]);
                        break;
                    case 20 :
                        img_scroll.setBackgroundResource(R.drawable.bs20);
                        txt_scroll.setText(babySize[19]);
                        break;
                    case 21 :
                        img_scroll.setBackgroundResource(R.drawable.bs21);
                        txt_scroll.setText(babySize[20]);
                        break;
                    case 22 :
                        img_scroll.setBackgroundResource(R.drawable.bs22);
                        txt_scroll.setText(babySize[21]);
                        break;
                    case 23 :
                        img_scroll.setBackgroundResource(R.drawable.bs23);
                        txt_scroll.setText(babySize[22]);
                        break;
                    case 24 :
                        img_scroll.setBackgroundResource(R.drawable.bs24);
                        txt_scroll.setText(babySize[23]);
                        break;
                    case 25 :
                        img_scroll.setBackgroundResource(R.drawable.bs25);
                        txt_scroll.setText(babySize[24]);
                        break;
                    case 26 :
                        img_scroll.setBackgroundResource(R.drawable.bs26);
                        txt_scroll.setText(babySize[25]);
                        break;
                    case 27 :
                        img_scroll.setBackgroundResource(R.drawable.bs27);
                        txt_scroll.setText(babySize[26]);
                        break;
                    case 28 :
                        img_scroll.setBackgroundResource(R.drawable.bs28);
                        txt_scroll.setText(babySize[27]);
                        break;
                    case 29 :
                        img_scroll.setBackgroundResource(R.drawable.bs29);
                        txt_scroll.setText(babySize[28]);
                        break;
                    case 30 :
                        img_scroll.setBackgroundResource(R.drawable.bs30);
                        txt_scroll.setText(babySize[29]);
                        break;
                    case 31 :
                        img_scroll.setBackgroundResource(R.drawable.bs31);
                        txt_scroll.setText(babySize[30]);
                        break;
                    case 32 :
                        img_scroll.setBackgroundResource(R.drawable.bs32);
                        txt_scroll.setText(babySize[31]);
                        break;
                    case 33 :
                        img_scroll.setBackgroundResource(R.drawable.bs33);
                        txt_scroll.setText(babySize[32]);
                        break;
                    case 34 :
                        img_scroll.setBackgroundResource(R.drawable.bs34);
                        txt_scroll.setText(babySize[33]);
                        break;
                    case 35 :
                        img_scroll.setBackgroundResource(R.drawable.bs35);
                        txt_scroll.setText(babySize[34]);
                        break;
                    case 36 :
                        img_scroll.setBackgroundResource(R.drawable.bs36);
                        txt_scroll.setText(babySize[35]);
                        break;
                    case 37 :
                        img_scroll.setBackgroundResource(R.drawable.bs37);
                        txt_scroll.setText(babySize[36]);
                        break;
                    case 38 :
                        img_scroll.setBackgroundResource(R.drawable.bs38);
                        txt_scroll.setText(babySize[37]);
                        break;
                    case 39 :
                        img_scroll.setBackgroundResource(R.drawable.bs39);
                        txt_scroll.setText(babySize[38]);
                        break;
                    case 40 :
                        img_scroll.setBackgroundResource(R.drawable.bs40);
                        txt_scroll.setText(babySize[39]);
                        break;
                    default:
                        img_scroll.setBackgroundResource(R.drawable.heartoff);
                        txt_scroll.setText("Congratulations");

                }
            }else if (scroll_pos == 104){
                switch (weeks_left){
                    case 1 :
                        txt_scroll.setText(guide[0]);
                        break;
                    case 2 :
                        txt_scroll.setText(guide[1]);
                        break;
                    case 3 :
                        txt_scroll.setText(guide[2]);
                        break;
                    case 4 :
                        txt_scroll.setText(guide[3]);
                        break;
                    case 5 :
                        txt_scroll.setText(guide[4]);
                        break;
                    case 6 :
                        txt_scroll.setText(guide[5]);
                        break;
                    case 7 :
                        txt_scroll.setText(guide[6]);
                        break;
                    case 8 :
                        txt_scroll.setText(guide[7]);
                        break;
                    case 9 :
                        txt_scroll.setText(guide[8]);
                        break;
                    case 10 :
                        txt_scroll.setText(guide[9]);
                        break;
                    case 11 :
                        txt_scroll.setText(guide[10]);
                        break;
                    case 12 :
                        txt_scroll.setText(guide[11]);
                        break;
                    case 13 :
                        txt_scroll.setText(guide[12]);
                        break;
                    case 14 :
                        txt_scroll.setText(guide[13]);
                        break;
                    case 15 :
                        txt_scroll.setText(guide[14]);
                        break;
                    case 16 :
                        txt_scroll.setText(guide[15]);
                        break;
                    case 17 :
                        txt_scroll.setText(guide[16]);
                        break;
                    case 18 :
                        txt_scroll.setText(guide[17]);
                        break;
                    case 19 :
                        txt_scroll.setText(guide[18]);
                        break;
                    case 20 :
                        txt_scroll.setText(guide[19]);
                        break;
                    case 21 :
                        txt_scroll.setText(guide[20]);
                        break;
                    case 22 :
                        txt_scroll.setText(guide[21]);
                        break;
                    case 23 :
                        txt_scroll.setText(guide[22]);
                        break;
                    case 24 :
                        txt_scroll.setText(guide[23]);
                        break;
                    case 25 :
                        txt_scroll.setText(guide[24]);
                        break;
                    case 26 :
                        txt_scroll.setText(guide[25]);
                        break;
                    case 27 :
                        txt_scroll.setText(guide[26]);
                        break;
                    case 28 :
                        txt_scroll.setText(guide[27]);
                        break;
                    case 29 :
                        txt_scroll.setText(guide[28]);
                        break;
                    case 30 :
                        txt_scroll.setText(guide[29]);
                        break;
                    case 31 :
                        txt_scroll.setText(guide[30]);
                        break;
                    case 32 :
                        txt_scroll.setText(guide[31]);
                        break;
                    case 33 :
                        txt_scroll.setText(guide[32]);
                        break;
                    case 34 :
                        txt_scroll.setText(guide[33]);
                        break;
                    case 35 :
                        txt_scroll.setText(guide[34]);
                        break;
                    case 36 :
                        txt_scroll.setText(guide[35]);
                        break;
                    case 37 :
                        txt_scroll.setText(guide[36]);
                        break;
                    case 38 :
                        txt_scroll.setText(guide[37]);
                        break;
                    case 39 :
                        txt_scroll.setText(guide[38]);
                        break;
                    case 40 :
                        txt_scroll.setText(guide[39]);
                        break;
                    default:
                        txt_scroll.setText("Congratulations");
                }
            }else if (scroll_pos == 105){

                switch (weeks_left){
                    case 1 :
                        txt_scroll.setText(mother_changes[0]);
                        break;
                    case 2 :
                        txt_scroll.setText(mother_changes[1]);
                        break;
                    case 3 :
                        txt_scroll.setText(mother_changes[2]);
                        break;
                    case 4 :
                        txt_scroll.setText(mother_changes[3]);
                        break;
                    case 5 :
                        txt_scroll.setText(mother_changes[4]);
                        break;
                    case 6 :
                        txt_scroll.setText(mother_changes[5]);
                        break;
                    case 7 :
                        txt_scroll.setText(mother_changes[6]);
                        break;
                    case 8 :
                        txt_scroll.setText(mother_changes[7]);
                        break;
                    case 9 :
                        txt_scroll.setText(mother_changes[8]);
                        break;
                    case 10 :
                        txt_scroll.setText(mother_changes[9]);
                        break;
                    case 11 :
                        txt_scroll.setText(mother_changes[10]);
                        break;
                    case 12 :
                        txt_scroll.setText(mother_changes[11]);
                        break;
                    case 13 :
                        txt_scroll.setText(mother_changes[12]);
                        break;
                    case 14 :
                        txt_scroll.setText(mother_changes[13]);
                        break;
                    case 15 :
                        txt_scroll.setText(mother_changes[14]);
                        break;
                    case 16 :
                        txt_scroll.setText(mother_changes[15]);
                        break;
                    case 17 :
                        txt_scroll.setText(mother_changes[16]);
                        break;
                    case 18 :
                        txt_scroll.setText(mother_changes[17]);
                        break;
                    case 19 :
                        txt_scroll.setText(mother_changes[18]);
                        break;
                    case 20 :
                        txt_scroll.setText(mother_changes[19]);
                        break;
                    case 21 :
                        txt_scroll.setText(mother_changes[20]);
                        break;
                    case 22 :
                        txt_scroll.setText(mother_changes[21]);
                        break;
                    case 23 :
                        txt_scroll.setText(mother_changes[22]);
                        break;
                    case 24 :
                        txt_scroll.setText(mother_changes[23]);
                        break;
                    case 25 :
                        txt_scroll.setText(mother_changes[24]);
                        break;
                    case 26 :
                        txt_scroll.setText(mother_changes[25]);
                        break;
                    case 27 :
                        txt_scroll.setText(mother_changes[26]);
                        break;
                    case 28 :
                        txt_scroll.setText(mother_changes[27]);
                        break;
                    case 29 :
                        txt_scroll.setText(mother_changes[28]);
                        break;
                    case 30 :
                        txt_scroll.setText(mother_changes[29]);
                        break;
                    case 31 :
                        txt_scroll.setText(mother_changes[30]);
                        break;
                    case 32 :
                        txt_scroll.setText(mother_changes[31]);
                        break;
                    case 33 :
                        txt_scroll.setText(mother_changes[32]);
                        break;
                    case 34 :
                        txt_scroll.setText(mother_changes[33]);
                        break;
                    case 35 :
                        txt_scroll.setText(mother_changes[34]);
                        break;
                    case 36 :
                        txt_scroll.setText(mother_changes[35]);
                        break;
                    case 37 :
                        txt_scroll.setText(mother_changes[36]);
                        break;
                    case 38 :
                        txt_scroll.setText(mother_changes[37]);
                        break;
                    case 39 :
                        txt_scroll.setText(mother_changes[38]);
                        break;
                    case 40 :
                        txt_scroll.setText(mother_changes[39]);
                        break;
                    default:
                        txt_scroll.setText("Congratulations");
                }

            }else if (scroll_pos == 106){

                switch (weeks_left){
                    case 1 :
                        txt_scroll.setText(tips[0]);
                        break;
                    case 2 :
                        txt_scroll.setText(tips[1]);
                        break;
                    case 3 :
                        txt_scroll.setText(tips[2]);
                        break;
                    case 4 :
                        txt_scroll.setText(tips[3]);
                        break;
                    case 5 :
                        txt_scroll.setText(tips[4]);
                        break;
                    case 6 :
                        txt_scroll.setText(tips[5]);
                        break;
                    case 7 :
                        txt_scroll.setText(tips[6]);
                        break;
                    case 8 :
                        txt_scroll.setText(tips[7]);
                        break;
                    case 9 :
                        txt_scroll.setText(tips[8]);
                        break;
                    case 10 :
                        txt_scroll.setText(tips[9]);
                        break;
                    case 11 :
                        txt_scroll.setText(tips[10]);
                        break;
                    case 12 :
                        txt_scroll.setText(tips[11]);
                        break;
                    case 13 :
                        txt_scroll.setText(tips[12]);
                        break;
                    case 14 :
                        txt_scroll.setText(tips[13]);
                        break;
                    case 15 :
                        txt_scroll.setText(tips[14]);
                        break;
                    case 16 :
                        txt_scroll.setText(tips[15]);
                        break;
                    case 17 :
                        txt_scroll.setText(tips[16]);
                        break;
                    case 18 :
                        txt_scroll.setText(tips[17]);
                        break;
                    case 19 :
                        txt_scroll.setText(tips[18]);
                        break;
                    case 20 :
                        txt_scroll.setText(tips[19]);
                        break;
                    case 21 :
                        txt_scroll.setText(tips[20]);
                        break;
                    case 22 :
                        txt_scroll.setText(tips[21]);
                        break;
                    case 23 :
                        txt_scroll.setText(tips[22]);
                        break;
                    case 24 :
                        txt_scroll.setText(tips[23]);
                        break;
                    case 25 :
                        txt_scroll.setText(tips[24]);
                        break;
                    case 26 :
                        txt_scroll.setText(tips[25]);
                        break;
                    case 27 :
                        txt_scroll.setText(tips[26]);
                        break;
                    case 28 :
                        txt_scroll.setText(tips[27]);
                        break;
                    case 29 :
                        txt_scroll.setText(tips[28]);
                        break;
                    case 30 :
                        txt_scroll.setText(tips[29]);
                        break;
                    case 31 :
                        txt_scroll.setText(tips[30]);
                        break;
                    case 32 :
                        txt_scroll.setText(tips[31]);
                        break;
                    case 33 :
                        txt_scroll.setText(tips[32]);
                        break;
                    case 34 :
                        txt_scroll.setText(tips[33]);
                        break;
                    case 35 :
                        txt_scroll.setText(tips[34]);
                        break;
                    case 36 :
                        txt_scroll.setText(tips[35]);
                        break;
                    case 37 :
                        txt_scroll.setText(tips[36]);
                        break;
                    case 38 :
                        txt_scroll.setText(tips[37]);
                        break;
                    case 39 :
                        txt_scroll.setText(tips[38]);
                        break;
                    case 40 :
                        txt_scroll.setText(tips[39]);
                        break;
                    default:
                        txt_scroll.setText("Congratulations");
                }

            }
        }
        /***************************************************************************************/



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scroll, menu);
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
