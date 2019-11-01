package com.myapp.madroid.babycare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hospital_BagsActivity extends AppCompatActivity {


    Typeface ssssss ;
    SharedPreferences shrd ;
    Button btn_baby_bag , btn_mother_bag  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital__bags);

        btn_baby_bag=(Button)findViewById(R.id.btn_baby_bag);
        btn_mother_bag=(Button)findViewById(R.id.btn_mother_bag);

        ssssss = Typeface.createFromAsset(getAssets(),"shahd.ttf");

        btn_baby_bag.setTypeface(ssssss);
        btn_mother_bag.setTypeface(ssssss);


        btn_baby_bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),hosp_bags_items_listViewActivity.class);
                intent.putExtra("bag","baby");
                startActivity(intent);
            }
        });

        btn_mother_bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),hosp_bags_items_listViewActivity.class);
                intent.putExtra("bag","mother");
                startActivity(intent);
            }
        });


    }
}
