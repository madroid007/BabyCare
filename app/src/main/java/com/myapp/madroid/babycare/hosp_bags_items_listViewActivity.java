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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class hosp_bags_items_listViewActivity extends AppCompatActivity {
    ListView listView ;
    Typeface ssssss ;
    ArrayList<hosp_bags_items> list_items_baby = new ArrayList<hosp_bags_items>();
    ArrayList<hosp_bags_items> list_items_mother = new ArrayList<hosp_bags_items>();
    String lang , type ;
    SharedPreferences shrd ;
    SharedPreferences.Editor editor ;
    String [] baby_items , mother_items;

    int [] baby_items_img = {R.drawable.bitem1,R.drawable.bitem2,R.drawable.bitem3,R.drawable.bitem4,R.drawable.bitem5,R.drawable.bitem6,R.drawable.bitem7,R.drawable.bitem8,R.drawable.bitem9,R.drawable.bitem10,R.drawable.bitem11};
    int [] mother_items_img = {R.drawable.mitem1,R.drawable.mitem2,R.drawable.mitem3,R.drawable.mitem4,R.drawable.mitem5,R.drawable.mitem6,R.drawable.mitem7,R.drawable.mitem8,R.drawable.mitem9,R.drawable.mitem10,R.drawable.mitem11,R.drawable.mitem12,R.drawable.mitem13,R.drawable.mitem14,R.drawable.mitem15,R.drawable.mitem16,R.drawable.mitem17,R.drawable.mitem18};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosp_bags_items_list_view);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);
        NativeExpressAdView adView2 = (NativeExpressAdView)findViewById(R.id.adView2);

        AdRequest request = new AdRequest.Builder().build();
        adView2.loadAd(request);



        ssssss = Typeface.createFromAsset(getAssets(),"shahd.ttf");
        listView =(ListView)findViewById(R.id.listview_hosp_bags);
        shrd = PreferenceManager.getDefaultSharedPreferences(this);
        editor=shrd.edit();
        lang = shrd.getString("language","ara");

        if (lang.equals("ara")){
            baby_items = getResources().getStringArray(R.array.baby_bag_ara);
            mother_items = getResources().getStringArray(R.array.mother_bag_ara);
        }else if (lang.equals("eng")){
            baby_items = getResources().getStringArray(R.array.baby_bag_eng);
            mother_items = getResources().getStringArray(R.array.mother_bag_eng);
        }

        type = getIntent().getStringExtra("bag");

        for (int i = 0; i < baby_items.length; i++) {
            list_items_baby.add(new hosp_bags_items(baby_items_img[i], baby_items[i]));
        }

        for (int j = 0; j < mother_items.length; j++) {
            list_items_mother.add(new hosp_bags_items(mother_items_img[j],mother_items[j]));
        }
        if (type.equals("baby")) {
            ListAdapter listAdapter = new ListAdapter(list_items_baby);
            listView.setAdapter(listAdapter);
        }else if (type.equals("mother")){
            ListAdapter listAdapter = new ListAdapter(list_items_mother);
            listView.setAdapter(listAdapter);
        }else {
            Toast.makeText(this, "there is somthing wrong", Toast.LENGTH_SHORT).show();
        }

    }

    public class ListAdapter extends BaseAdapter {
        ArrayList<hosp_bags_items>listBags_items = new ArrayList<hosp_bags_items>();
        ListAdapter(ArrayList<hosp_bags_items>arrItems){
            this.listBags_items = arrItems ;
        }

        @Override
        public int getCount() {
            return listBags_items.size();
        }

        @Override
        public Object getItem(int pos) {
            return pos;
        }

        @Override
        public long getItemId(int pos) {
            return listBags_items.get(pos).item_img;
        }

        @Override
        public View getView(final int pos, View convertView, ViewGroup parent) {

            LayoutInflater lf =getLayoutInflater();
            View v = lf.inflate(R.layout.hosp_bags_items_layout,null);

            final TextView item_txt =(TextView)v.findViewById(R.id.txt_layout_hosp_bags);
            final ImageView item_image =(ImageView) v.findViewById(R.id.img_layout_hosp_bags);

            item_txt.setText(listBags_items.get(pos).item_txt);
            item_txt.setTypeface(ssssss);

            item_image.setBackgroundResource(listBags_items.get(pos).item_img);

            return v;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hosp_bags_items_list_view, menu);
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
