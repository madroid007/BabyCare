package com.myapp.madroid.babycare;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BabyNamesActivity extends AppCompatActivity {

    Button btn_boy , btn_girl  ;
    ImageView img_boy , img_girl ;
    Typeface ssssss ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_names);


        btn_boy=(Button)findViewById(R.id.btn_boynames);
        btn_girl=(Button)findViewById(R.id.btn_girlnames);
        img_boy = (ImageView)findViewById(R.id.img_boynames);
        img_girl = (ImageView)findViewById(R.id.img_girlnames);

        ssssss = Typeface.createFromAsset(getAssets(),"shahd.ttf");


        btn_girl.setTypeface(ssssss);
        btn_boy.setTypeface(ssssss);



        btn_boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NamesListViewActivity.class);
                intent.putExtra("gender","boy");
                startActivity(intent);
            }
        });

        btn_girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NamesListViewActivity.class);
                intent.putExtra("gender","girl");
                startActivity(intent);
            }
        });


        img_boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NamesListViewActivity.class);
                intent.putExtra("gender","boy");
                startActivity(intent);
            }
        });

        img_girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NamesListViewActivity.class);
                intent.putExtra("gender","girl");
                startActivity(intent);
            }
        });


    }
}
