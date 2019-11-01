package com.myapp.madroid.babycare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class LanguageActivity extends AppCompatActivity {

    TextView language ;
    Button btn ;
    RadioButton rbtn_ara , rbtn_eng ;
    Typeface ssssss ;
    SharedPreferences shrd ;
    SharedPreferences.Editor editor ;
    Boolean isFirstRun ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        ssssss = Typeface.createFromAsset(getAssets(),"shahd.ttf");
        language = (TextView)findViewById(R.id.txt_language);
        btn  = (Button)findViewById(R.id.btn_continue);
        rbtn_ara = (RadioButton)findViewById(R.id.rbtn_ara);
        rbtn_eng = (RadioButton)findViewById(R.id.rbtn_eng);

        language.setTypeface(ssssss);
        btn.setTypeface(ssssss);
        rbtn_eng.setTypeface(ssssss);
        rbtn_ara.setTypeface(ssssss);

        shrd = PreferenceManager.getDefaultSharedPreferences(this);
        editor = shrd.edit();

        isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", false);


        if (isFirstRun) {
            //show start activity
            startActivity(new Intent(getApplicationContext(), AttentionActivity.class));
            finish();
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", true).commit();

        String lang = shrd.getString("language","ara");

        rbtn_ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("language","ara");
                editor.commit();
            }
        });

        rbtn_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("language","eng");
                editor.commit();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AttentionActivity.class));
            }
        });






    }
}
