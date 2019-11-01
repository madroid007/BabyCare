package com.myapp.madroid.babycare;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Mad on 8/24/2017.
 */

public class Frag4 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment4, container, false);

        Button btn_babynames = (Button)v.findViewById(R.id.btn_babynames);
        Button btn_videos = (Button)v.findViewById(R.id.btn_videos);
       // Button btn_wensite = (Button)v.findViewById(R.id.btn_website);
        Button btn_hosp_bags = (Button)v.findViewById(R.id.btn_hosp_bags);
        Button btn_facebook = (Button)v.findViewById(R.id.btn_facebook);
        Button btn_moreapps = (Button)v.findViewById(R.id.btn_moreapp);


        btn_babynames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(),NationalNamesActivity.class);
                startActivity(intent);
            }
        });
        btn_videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appIntent =new Intent(Intent.ACTION_VIEW);
                appIntent.setData(Uri.parse("https://www.youtube.com/channel/UCMONpz90ssWrpEdbAQeMVDA"));
                startActivity(appIntent);
            }
        });

        btn_hosp_bags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(),Hospital_BagsActivity.class);
                startActivity(intent);
            }
        });
        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appIntent =new Intent(Intent.ACTION_VIEW);
                appIntent.setData(Uri.parse("https://www.facebook.com/Mybaby-care-1921660684757992/"));
                startActivity(appIntent);
            }
        });
        btn_moreapps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appIntent =new Intent(Intent.ACTION_VIEW);
                appIntent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=maDroid007"));
                startActivity(appIntent);
            }
        });


        //Inflate the layout for this fragment

        return v;
    }


}
