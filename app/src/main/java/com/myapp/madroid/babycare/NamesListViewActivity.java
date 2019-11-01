package com.myapp.madroid.babycare;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.NativeExpressAdView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NamesListViewActivity extends AppCompatActivity {

    ListView listView ;
    Typeface ssssss ;
    ArrayList<names_list> list_names_boys = new ArrayList<names_list>();
    ArrayList<names_list> list_names_girls = new ArrayList<names_list>();
    String nationality , gender;
    SharedPreferences shrd ;
    SharedPreferences.Editor editor ;
    String [] boy_names , girl_names;
    int name_pos ;
    int [] positions=new int[3000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names_list_view);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);


        NativeExpressAdView adView2 = (NativeExpressAdView)findViewById(R.id.adView2);

        AdRequest request = new AdRequest.Builder().build();
        adView2.loadAd(request);


        ssssss = Typeface.createFromAsset(getAssets(),"shahd.ttf");
        listView =(ListView)findViewById(R.id.listviewwwwww);
        shrd = PreferenceManager.getDefaultSharedPreferences(this);
        editor=shrd.edit();
        nationality = shrd.getString("nationality","arabic");

        if (nationality.equals("america")){
            boy_names = getResources().getStringArray(R.array.names_american_boy);
            girl_names = getResources().getStringArray(R.array.names_american_girl);
        }else if (nationality.equals("arabic")){
            boy_names = getResources().getStringArray(R.array.boy_names_ara);
            girl_names = getResources().getStringArray(R.array.girl_names_ara);
        }else if (nationality.equals("british")){
            boy_names = getResources().getStringArray(R.array.names_british_boy);
            girl_names = getResources().getStringArray(R.array.names_british_girl);
        } else if (nationality.equals("canada")){
            boy_names = getResources().getStringArray(R.array.names_canadian_boy);
            girl_names = getResources().getStringArray(R.array.names_canadian_girl);
        } else if (nationality.equals("france")){
            boy_names = getResources().getStringArray(R.array.names_french_boy);
            girl_names = getResources().getStringArray(R.array.names_french_girl);
        }else if (nationality.equals("germany")){
            boy_names = getResources().getStringArray(R.array.names_german_boy);
            girl_names = getResources().getStringArray(R.array.names_german_girl);
        }

        gender = getIntent().getStringExtra("gender");
        for (int i = 0; i < boy_names.length; i++) {
            list_names_boys.add(new names_list(R.drawable.heartoff, boy_names[i]));
            positions[i]=0;
        }

        for (int j = 0; j < girl_names.length; j++) {
            list_names_girls.add(new names_list(R.drawable.heartoff,girl_names[j]));
            positions[j]=0;
        }
        if (gender.equals("boy")) {
            ListAdapter listAdapter = new ListAdapter(list_names_boys);
            listView.setAdapter(listAdapter);
        }else if (gender.equals("girl")){
            ListAdapter listAdapter = new ListAdapter(list_names_girls);
            listView.setAdapter(listAdapter);
        }else {
            Toast.makeText(this, "there is somthing wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public class ListAdapter extends BaseAdapter {
        ArrayList<names_list>listNames_items = new ArrayList<names_list>();
        ListAdapter(ArrayList<names_list>arrItems){
            this.listNames_items = arrItems ;
        }

        @Override
        public int getCount() {
            return listNames_items.size();
        }

        @Override
        public Object getItem(int pos) {
            return pos;
        }

        @Override
        public long getItemId(int pos) {
            return listNames_items.get(pos).heart_num;
        }

        @Override
        public View getView(final int pos, View convertView, ViewGroup parent) {

            LayoutInflater lf =getLayoutInflater();
            View v = lf.inflate(R.layout.names_layout,null);

            final TextView baby_name =(TextView)v.findViewById(R.id.txt_layout_baby_name);
            final Button heart_num=(Button) v.findViewById(R.id.btn_heart);

            baby_name.setText(listNames_items.get(pos).baby_name);
            baby_name.setTypeface(ssssss);

            int boy_heart_state = shrd.getInt("boy_pos"+pos,0);
            int girl_heart_state=shrd.getInt("girl_pos"+pos,0);
            if (gender.equals("boy")){
                if (boy_heart_state == 0) {
                    heart_num.setBackgroundResource(R.drawable.heartoff);
                }else if (boy_heart_state==1){
                    heart_num.setBackgroundResource(R.drawable.hhhhhhhhhhhh);
                }
            }else if (gender.equals("girl")){
                if (girl_heart_state == 0) {
                    heart_num.setBackgroundResource(R.drawable.heartoff);
                }else if (girl_heart_state==1){
                    heart_num.setBackgroundResource(R.drawable.hhhhhhhhhhhh);
                }
            }


            heart_num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name_pos = pos ;

                    if (gender.equals("boy")){
                        if (positions[pos]==0) {
                            positions[pos] = 1;
                            editor.putInt("boy_pos"+pos,1);
                            editor.apply();
                            heart_num.setBackgroundResource(R.drawable.hhhhhhhhhhhh);
                            baby_name.setTextColor(Color.parseColor("#f4719a"));
                        }else if (positions[pos]==1){
                            positions[pos]=0;
                            editor.putInt("boy_pos"+pos,0);
                            editor.apply();
                            heart_num.setBackgroundResource(R.drawable.heartoff);
                            baby_name.setTextColor(Color.parseColor("#000000"));
                        }
                    }else if (gender.equals("girl")){
                        if (positions[pos]==0) {
                            positions[pos] = 1;
                            editor.putInt("girl_pos"+pos,1);
                            editor.apply();
                            heart_num.setBackgroundResource(R.drawable.hhhhhhhhhhhh);
                            baby_name.setTextColor(Color.parseColor("#f4719a"));
                        }else if (positions[pos]==1){
                            positions[pos]=0;
                            editor.putInt("girl_pos"+pos,0);
                            editor.apply();
                            heart_num.setBackgroundResource(R.drawable.heartoff);
                            baby_name.setTextColor(Color.parseColor("#000000"));
                        }
                    }
                }
            });

            return v;
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_names_list_view, menu);
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
