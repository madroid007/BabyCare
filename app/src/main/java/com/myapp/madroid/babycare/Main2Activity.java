package com.myapp.madroid.babycare;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.R.id.list;


public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    TextView txt_name , txt_hight , txt_weight , txt_birth_date , txt_bmi_calc ;
    EditText etxt_name ;
    Button btn_ok , btn_next ;
    int [] days , months  , years , hights , weights ;
    String [] monthsARA , monthsEng ;
    Typeface face , font , ssssss ;
    int selectedYear , selectedMonth , selectedDay , selectedWeight , selectedHight ;
    int yearPos , monthPos , dayPos ,hightPos , weightPos , yearFlag = 0 , monthFlag =0 , dayFlag = 0 , nameFlag =0 , hightFlag = 0 , weightFlag = 0 , ok_flag = 0;
    ArrayList listYears = new ArrayList();
    ArrayList listMonths = new ArrayList();
    ArrayList listDays = new ArrayList();
    ArrayList listHights = new ArrayList();
    ArrayList listWeights = new ArrayList();
    String name , bmi_string , lang ;
    long diff  ;
    int diff_days , diff_weeks ,  daaaaaaaays , weeeeeeeeks ;
    float bmi ;
    SharedPreferences shrd ;
    SharedPreferences.Editor editor ;
    boolean isFirstRun2 ;
    AlarmManager alarmManager ;
    Intent notifyIntent ;
    PendingIntent pendingIntent ;
    Calendar cal , today , notifyCal;
    Spinner spin_year , spin_month , spin_day , spin_hight , spin_weight ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final String ACTION_NEW_WEEK = "new-week-is-here";



        font = Typeface.createFromAsset(getAssets(),"kufi.ttf");
        face = Typeface.createFromAsset(getAssets(),"decorative.ttf");
        ssssss = Typeface.createFromAsset(getAssets(),"shahd.ttf");

        shrd = PreferenceManager.getDefaultSharedPreferences(this);
        editor = shrd.edit();
        lang = shrd.getString("language","ara");

        ok_flag=shrd.getInt("ok_flag",0);


        isFirstRun2 = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun2", false);

        if (isFirstRun2 && ok_flag >=1) {
            //show start activity
            startActivity(new Intent(Main2Activity.this, FragActivity.class));
            finish();
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun2", true).apply();

        txt_name = (TextView)findViewById(R.id.txt_name);
        txt_name.setTypeface(ssssss);
        txt_hight = (TextView)findViewById(R.id.txt_hight);
        txt_hight.setTypeface(ssssss);
        txt_weight = (TextView)findViewById(R.id.txt_weight);
        txt_weight.setTypeface(ssssss);
        txt_birth_date = (TextView)findViewById(R.id.txt_enter_date);
        txt_birth_date.setTypeface(ssssss);
        txt_bmi_calc = (TextView)findViewById(R.id.txt_calc_bmi);
        txt_bmi_calc.setTypeface(ssssss);
        etxt_name = (EditText)findViewById(R.id.etxt_name);
        etxt_name.setTypeface(font);
        spin_hight = (Spinner) findViewById(R.id.btn_hight);
        spin_weight = (Spinner) findViewById(R.id.btn_weight);
        spin_day = (Spinner) findViewById(R.id.btn_preg_day);
        spin_month = (Spinner) findViewById(R.id.btn_preg_month);
        spin_year= (Spinner) findViewById(R.id.btn_preg_year);
        btn_ok = (Button)findViewById(R.id.btn_Ok);
        btn_ok.setTypeface(font);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_next.setTypeface(font);



        hights=new int[]{130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200};
        //      lv_hights = new ListView(this);
        //      ArrayAdapter aa_hights = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listHights);
        //      lv_hights.setAdapter(aa_hights);

        for (int t =0 ; t<hights.length ;t++)
        {
            listHights.add(hights[t]);
        }

        ArrayAdapter<String> hightAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listHights);
        hightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_hight.setAdapter(hightAdapter);


        weights=new int[]{40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250};
        //    lv_weights = new ListView(this);
        //     ArrayAdapter aa_weights = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listWeights);
        //     lv_weights.setAdapter(aa_weights);

        for (int y =0 ; y<weights.length ;y++)
        {
            listWeights.add(weights[y]);
        }


        ArrayAdapter<String> weightAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listWeights);
        hightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_weight.setAdapter(weightAdapter);



        years=new int[]{2016,2017,2018,2019,2020,2021,2022,2023,2024,2025,2026,2027,2028,2029,2030};
//        lv_years = new ListView(this);
//        ArrayAdapter aa_years = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listYears);
//        lv_years.setAdapter(aa_years);

        for (int i =0 ; i<years.length ;i++)
        {
            listYears.add(years[i]);
        }


        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listYears);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_year.setAdapter(yearAdapter);



        months=new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        monthsARA=new String[]{"يناير","فبراير","مارس","ابريل","مايو","يونيه","يوليو","اغسطس","سبتمبر","اكتوبر","نوفمبر","ديسمبر"};
        monthsEng=new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Seb","Oct","Nov","Dec"};
//        lv_months = new ListView(this);
//        ArrayAdapter aa_months = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listMonths);
//        lv_months.setAdapter(aa_months);

        for (int j =0 ; j<months.length ;j++)
        {
            if (lang.equalsIgnoreCase("eng")) {
                listMonths.add(monthsEng[j]);
            }else {
                listMonths.add(monthsARA[j]);
            }
        }


        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listMonths);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_month.setAdapter(monthAdapter);



        days= new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
//        lv_days = new ListView(this);
//        ArrayAdapter aa_days = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listDays);
//        lv_days.setAdapter(aa_days);

        for (int k =0 ; k<days.length-1 ;k++)
        {
            listDays.add(days[k]);
        }


        ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listDays);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_day.setAdapter(dayAdapter);



//        popupWindowYears = popupWindowYears() ;
//        popupWindowDays = popupWindowDays();
//        popupWindowMonths = popupWindowMonths();
//        popupWindowHights = popupWindowHights();
//        popupWindowWeights = popupWindowWeights();

        etxt_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameFlag ++ ;
            }
        });
        spin_hight.setOnItemSelectedListener(this);
        spin_weight.setOnItemSelectedListener(this);
        spin_year.setOnItemSelectedListener(this);
        spin_month.setOnItemSelectedListener(this);
        spin_day.setOnItemSelectedListener(this);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                daaaaaaaays=shrd.getInt("daaaaaaaays",1000);

                View mview = getCurrentFocus();
                if (mview != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                if (nameFlag >= 1 && hightFlag >= 1 && weightFlag >= 1 && dayFlag >= 1 && monthFlag >= 1 && yearFlag >= 1) {

                    ok_flag++;

                    name = etxt_name.getText().toString();
                    editor.putString("name", name);
                    editor.apply();

                    cal = Calendar.getInstance();
                    cal.set(Calendar.YEAR, selectedYear);
                    cal.set(Calendar.DAY_OF_MONTH, selectedDay);
                    switch (selectedMonth) {
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
                    today = Calendar.getInstance();

                    diff = cal.getTimeInMillis() - today.getTimeInMillis();
                    diff_days = (int) (diff / (1000 * 60 * 60 * 24));
                    diff_weeks = (int) (diff / (7 * 1000 * 60 * 60 * 24));
                    bmi = selectedWeight / (selectedHight * selectedHight / 10000);
                    weeeeeeeeks = 40 - diff_weeks;
                    daaaaaaaays = 281 - diff_days;
                    editor.putInt("daaaaaaaays", daaaaaaaays);
                    editor.apply();



                    if (bmi < 18.5) {
                        if (lang=="ara"){
                            bmi_string = "لديكي نقص وزن يجب عليكي الاهتمام بوزنك لانه يزيد من صحة طفلك";
                        }else if (lang == "eng"){
                            bmi_string = "You have UnderWeight";
                        }
                    } else if (bmi > 18.5 && bmi < 25) {
                        if (lang=="ara"){
                            bmi_string = "انتي لديكي وزن مثالي";
                        }else if (lang == "eng"){
                            bmi_string = "You have Perfect Weight";
                        }

                    } else if (bmi >= 25 && bmi < 30) {
                        if (lang=="ara"){
                            bmi_string = "لديكي وزن زائد ";
                        }else if (lang == "eng"){
                            bmi_string = "You have Over Weight";
                        }

                    } else if (bmi >= 30 && bmi < 35) {
                        if (lang=="ara"){
                            bmi_string = "لديكي بدانة قليلة";
                        }else if (lang == "eng"){
                            bmi_string = "You have Obesse 1";
                        }

                    } else if (bmi >= 35 && bmi < 40) {
                        if (lang=="ara"){
                            bmi_string = "لديكي بدانة متوسطة";
                        }else if (lang == "eng"){
                            bmi_string = "You have Obesse 2";
                        }

                    } else if (bmi >= 40) {
                        if (lang=="ara"){
                            bmi_string = "لديكي بدانة كبيرة يجب عليك المتابعة مع طبيب لتحافظي علي صحة طفلك";
                        }else if (lang == "eng"){
                            bmi_string = "You have Obesse 3";
                        }

                    }

                    if (lang=="ara"){
                        txt_bmi_calc.setText("انتي الآن في الاسبوع"  + weeeeeeeeks + "\n" + "باقي علي الولادة " + diff_days + " يوم " +"\n"+ "مؤشر كتلة الجسم لديكي" + bmi + "\n" + bmi_string);
                    }else if (lang == "eng"){
                        txt_bmi_calc.setText("You are in week" + weeeeeeeeks + "\n" + "there are "  + diff_days + "days before your Due date" +"\n"+ "Your Body Mass Index (BMI) is " + bmi + "\n" + bmi_string);
                    }
                } else {
                    if (lang=="ara"){
                        Toast.makeText(Main2Activity.this, "من فضلك اكمل البيانات", Toast.LENGTH_SHORT).show();
                    }else if (lang == "eng"){
                        Toast.makeText(Main2Activity.this, "Please Complete the required info", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (daaaaaaaays != 1000) {
                    if (daaaaaaaays < 0 || daaaaaaaays >281) {
                        if (lang=="ara"){
                            Toast.makeText(Main2Activity.this, "من فضلك اختر تاريخ مناسب , يجب الا يكون موعد الولادة اكثر من 40 اسبوع من الان", Toast.LENGTH_SHORT).show();
                        }else if (lang == "eng"){
                            Toast.makeText(Main2Activity.this, "Please choose an appropriate date , Due date must not exceed 40 weeks from now", Toast.LENGTH_SHORT).show();
                        }


                    }else {


                        if (ok_flag >= 1) {
                            // cal = Calendar.getInstance();
                            cal.set(Calendar.DAY_OF_MONTH,selectedDay);
                            cal.set(Calendar.YEAR,selectedYear);

                            switch (selectedMonth) {
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

                            int WEEK_INTERVAL = 7 * 1000 * 60 * 60 * 24 ;
                            int PREGNANCY_INTERVAL = 281 * 1000 * 60 * 60 * 24 ;
                            today = Calendar.getInstance();

                            //calender_for_begining_of_pregnancy
                            notifyCal = Calendar.getInstance();


                            long newDiff = cal.getTimeInMillis() - today.getTimeInMillis();
                            diff_weeks = (int) (newDiff / (WEEK_INTERVAL));
                            weeeeeeeeks = 40 - diff_weeks;

                            if (weeeeeeeeks > 0) {

                                //set the calender to the first coming week
//                                notifyCal.set(Calendar.DAY_OF_YEAR,(cal.get(Calendar.DAY_OF_YEAR)-(diff_weeks*7)));
//                                notifyCal.set(Calendar.HOUR_OF_DAY,12);
//                                notifyCal.set(Calendar.MINUTE,0);

                                cal.set(Calendar.HOUR_OF_DAY,12);
                                cal.set(Calendar.MINUTE,0);

                                notifyIntent = new Intent(getApplicationContext(), AlarmReciever.class);
                                //        notifyIntent.setAction(ACTION_NEW_WEEK);
                                notifyIntent.putExtra("weeeeeeeeks",weeeeeeeeks);
                                alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), weeeeeeeeks, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 2*24*60*60*1000, pendingIntent);


                                Log.v("cal",""+cal.toString());
                                Log.v("notify cal",""+notifyCal.toString());
                                Log.v("Today",""+today.toString());


                            }


                            ok_flag++;
                            editor.putInt("ok_flag",ok_flag);
                            editor.apply();


                            Intent intent = new Intent(Main2Activity.this, FragActivity.class);
                            startActivity(intent);
                            finish();


                        } else {
                            if (lang=="ara"){
                                Toast.makeText(Main2Activity.this, "من فضلك اضغط علي زر Ok", Toast.LENGTH_SHORT).show();
                            }else if (lang == "eng"){
                                Toast.makeText(Main2Activity.this, "Please press OK", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

        switch (adapterView.getId()){

            case R.id.btn_hight :

                hightFlag++;
                hightPos = position ;
                selectedHight = hights[position];
                editor.putInt("selectedHight",selectedHight);
                editor.apply();
                spin_hight.setPrompt(selectedHight+"");

                break;

            case R.id.btn_weight :

                weightFlag++;
                weightPos = position ;
                selectedWeight = weights[position];
                editor.putInt("selectedWeight",selectedWeight);
                editor.apply();
                spin_weight.setPrompt(selectedWeight+"");


                break;

            case R.id.btn_preg_year :

                yearFlag++;
                yearPos = position ;
                selectedYear = years[position];
                editor.putInt("selectedYear",selectedYear);
                editor.apply();
                spin_year.setPrompt(selectedYear+"");


                break;

            case R.id.btn_preg_month :

                monthFlag++;
                monthPos = position ;
                selectedMonth = months[position];
                editor.putInt("selectedMonth",selectedMonth);
                editor.apply();
                spin_month.setPrompt(selectedMonth+"");



                break;

            case R.id.btn_preg_day :

                dayFlag++;
                dayPos = position ;
                selectedDay = days[position];
                editor.putInt("selectedDay",selectedDay);
                editor.apply();
                spin_day.setPrompt(selectedDay+"");


                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
