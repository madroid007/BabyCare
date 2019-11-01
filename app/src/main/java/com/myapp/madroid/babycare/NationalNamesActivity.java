package com.myapp.madroid.babycare;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NationalNamesActivity extends AppCompatActivity {

    private static final int START_LEVEL = 1;
    private int mLevel;
    private Button mNextLevelButton;
    private InterstitialAd mInterstitialAd;

    TextView names_title ;
    Button btn_arabic_names , btn_american_names , btn_british_names , btn_canadian_names , btn_french_names , btn_germain_names ;
    Typeface ssssss ;
    SharedPreferences shrd ;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_names);

        // Create the next level button, which tries to show an interstitial when clicked.
        mNextLevelButton = ((Button) findViewById(R.id.next_level_button));
        mNextLevelButton.setEnabled(false);
        mNextLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial();
            }
        });

        // Create the text view to show the level number.


        // Create the InterstitialAd and set the adUnitId (defined in values/strings.xml).
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();

        ssssss = Typeface.createFromAsset(getAssets(),"shahd.ttf");
        names_title = (TextView)findViewById(R.id.title_nation_names);
        btn_american_names = (Button)findViewById(R.id.btn_american_names);
        btn_arabic_names = (Button)findViewById(R.id.btn_arabic_names);
        btn_british_names = (Button)findViewById(R.id.btn_british_names);
        btn_canadian_names = (Button)findViewById(R.id.btn_canadian_names);
        btn_french_names = (Button)findViewById(R.id.btn_french_names);
        btn_germain_names = (Button)findViewById(R.id.btn_german_names);

        shrd = PreferenceManager.getDefaultSharedPreferences(this);
        editor=shrd.edit();


        names_title.setTypeface(ssssss);
        btn_american_names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("nationality","america");
                editor.apply();
                Intent intent = new Intent(getApplicationContext(),BabyNamesActivity.class);
                startActivity(intent);
                loadInterstitial();
            }
        });
        btn_arabic_names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("nationality","arabic");
                editor.apply();
                Intent intent = new Intent(getApplicationContext(),BabyNamesActivity.class);
                startActivity(intent);
                loadInterstitial();
            }
        });
        btn_british_names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("nationality","british");
                editor.apply();
                Intent intent = new Intent(getApplicationContext(),BabyNamesActivity.class);
                startActivity(intent);
                loadInterstitial();
            }
        });
        btn_canadian_names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("nationality","canada");
                editor.apply();
                Intent intent = new Intent(getApplicationContext(),BabyNamesActivity.class);
                startActivity(intent);
                loadInterstitial();
            }
        });
        btn_french_names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("nationality","france");
                editor.apply();
                Intent intent = new Intent(getApplicationContext(),BabyNamesActivity.class);
                startActivity(intent);
                loadInterstitial();
            }
        });
        btn_germain_names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("nationality","germany");
                editor.apply();
                Intent intent = new Intent(getApplicationContext(),BabyNamesActivity.class);
                startActivity(intent);
                loadInterstitial();
            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_national_names, menu);
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
