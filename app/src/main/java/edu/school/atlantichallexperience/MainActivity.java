package edu.school.atlantichallexperience;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private  BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mItemSelectedListener);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_container, new HomeFragment(), HomeFragment.TAG)
                .addToBackStack(null)
                .commit();
        MobileAds.initialize(this, getResources().getString(R.string.app_id));
        startAds();
    }


    public void startAds() {
        final AdView mAdView = (AdView) findViewById(R.id.adView);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                mAdView.setVisibility(View.GONE);
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
                super.onAdLoaded();
            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
                    final FragmentManager supportFragmentManager = getSupportFragmentManager();
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            mTextMessage.setText(R.string.title_home);
                            Fragment homeFragment = supportFragmentManager.findFragmentByTag(HomeFragment.TAG);
                            if (homeFragment == null) {
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.content_container, new HomeFragment(), HomeFragment.TAG)
                                        .addToBackStack(null)
                                        .commit();
                            } else {
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.content_container, homeFragment)
                                        .addToBackStack(null)
                                        .commit();
                            }
                            navigation.getMenu().getItem(0).setChecked(true);
                            break;
                        case R.id.navigation_information:
                            mTextMessage.setText(R.string.title_info);
                            Fragment locationsFragment = supportFragmentManager.findFragmentByTag(InfoFragment.TAG);
                            if (locationsFragment == null) {
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.content_container, new InfoFragment(), InfoFragment.TAG)
                                        .addToBackStack(null)
                                        .commit();
                            } else {
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.content_container, locationsFragment)
                                        .addToBackStack(null)
                                        .commit();
                            }
                            navigation.getMenu().getItem(1).setChecked(true);
                            break;
                        case R.id.navigation_contact:
                            mTextMessage.setText(R.string.title_contact);
                            Fragment menuFragment = supportFragmentManager.findFragmentByTag(ContactFragment.TAG);
                            if (menuFragment == null) {
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.content_container, new ContactFragment(), ContactFragment.TAG)
                                        .addToBackStack(null)
                                        .commit();
                            } else {
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.content_container, menuFragment)
                                        .addToBackStack(null)
                                        .commit();
                            }
                            navigation.getMenu().getItem(2).setChecked(true);
                            break;
                    }
                    return false;
                }
            };

}
