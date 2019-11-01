package com.myapp.madroid.babycare;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragActivity extends AppCompatActivity {
    // Remove the below line after defining your own ad unit ID.
    Fragment fragment ;
    FragmentManager fm ;
    FragmentTransaction fragmentTransaction ;
    TextView tv_frag1 , tv_frag2 , tv_frag3 , tv_frag4 ;

    private static final int START_LEVEL = 1;
    private int mLevel;
    private Button mNextLevelButton;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        mNextLevelButton = ((Button) findViewById(R.id.next_level_button));
        mNextLevelButton.setEnabled(false);
        mNextLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial();
            }
        });

        // Create the text view to show the level number.
        mLevel = START_LEVEL;

        // Create the InterstitialAd and set the adUnitId (defined in values/strings.xml).
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);


        tv_frag1 = (TextView) findViewById(R.id.btn_frag1);
        tv_frag2 = (TextView)findViewById(R.id.btn_frag2);
        tv_frag3 = (TextView)findViewById(R.id.btn_frag3);
        tv_frag4 = (TextView)findViewById(R.id.btn_frag4);

        fragment=new Frag1();
        transFrag();
        tv_frag1.setTextColor(Color.WHITE);
        tv_frag2.setTextColor(Color.BLACK);
        tv_frag3.setTextColor(Color.BLACK);
        tv_frag4.setTextColor(Color.BLACK);



        tv_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial();
                tv_frag1.setTextColor(Color.WHITE);
                tv_frag2.setTextColor(Color.BLACK);
                tv_frag3.setTextColor(Color.BLACK);
                tv_frag4.setTextColor(Color.BLACK);
                fragment=new Frag1();
                transFrag();
            }
        });
        tv_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial();
                tv_frag1.setTextColor(Color.BLACK);
                tv_frag2.setTextColor(Color.WHITE);
                tv_frag3.setTextColor(Color.BLACK);
                tv_frag4.setTextColor(Color.BLACK);
                fragment=new Frag2();
                transFrag();
            }
        });
        tv_frag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial();
                tv_frag1.setTextColor(Color.BLACK);
                tv_frag2.setTextColor(Color.BLACK);
                tv_frag3.setTextColor(Color.WHITE);
                tv_frag4.setTextColor(Color.BLACK);
                fragment=new Frag3();
                transFrag();
            }
        });
        tv_frag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial();
                tv_frag1.setTextColor(Color.BLACK);
                tv_frag2.setTextColor(Color.BLACK);
                tv_frag3.setTextColor(Color.BLACK);
                tv_frag4.setTextColor(Color.WHITE);
                fragment=new Frag4();
                transFrag();
            }
        });

    }

    public void transFrag (){

        fm = getFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frammmmmmm, fragment);
        fragmentTransaction.commit();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_, menu);
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

    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mNextLevelButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                mNextLevelButton.setEnabled(true);
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                goToNextLevel();
            }
        });
        return interstitialAd;
    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            goToNextLevel();
        }
    }

    private void loadInterstitial() {
        // Disable the next level button and load the ad.
        mNextLevelButton.setEnabled(false);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
    }

    private void goToNextLevel() {
        // Show the next level and reload the ad to prepare for the level after.
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }
}
