package adloading.kun.com.adall;

/**
 * Created by Administrator on 2018/3/27 0027.
 */


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardedVideoAd;


public class zhinanzhen extends AppCompatActivity {



    private AdView mAdView;
    private AdView mAdView_1;
    private AdView mAdView_2;
    private AdView mAdView_3;
    private AdView mAdView_4;
    private AdView mAdView_5;
    private AdView mAdView_6;
    private AdView mAdView_7;
    private AdView mAdView_8;
    private AdView mAdView_9;
    private AdView mAdView_10;
    private AdView mAdView_11;


    private InterstitialAd mInterstitialAd;
    private Switch mSwith;
    private int TIME;  //随机时间.
    private RewardedVideoAd mRewardedVideoAd;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_zhinanzhen);
        initView();
    }

    private void initView() {

        mSwith = (Switch) findViewById(R.id.switch1);

        CheckBoxListener listener = new CheckBoxListener();
        mSwith.setOnCheckedChangeListener(listener);


        mAdView = findViewById(R.id.adView);
        mAdView_1 = findViewById(R.id.adView_1);
        mAdView_2 = findViewById(R.id.adView_2);
        mAdView_3 = findViewById(R.id.adView_3);
        mAdView_4 = findViewById(R.id.adView_4);
        mAdView_5 = findViewById(R.id.adView_5);
        mAdView_6 = findViewById(R.id.adView_6);
        mAdView_7 = findViewById(R.id.adView_7);
        mAdView_8 = findViewById(R.id.adView_8);
        mAdView_9 = findViewById(R.id.adView_9);




    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        /////////////////////定时器///////////////////////////////////////
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int TIME = (int)((Math.random() * 8 + 0.5)*10000)-737;
                handler.postDelayed(this, TIME);
                Toast.makeText(zhinanzhen.this, String.valueOf(TIME), Toast.LENGTH_SHORT).show();

                AdRequest adRequest = new AdRequest.Builder().build();
//                mAdView.loadAd(adRequest);
//                AdRequest adRequest1 = new AdRequest.Builder().build();
//                mAdView_1.loadAd(adRequest1);
//                AdRequest adRequest2 = new AdRequest.Builder().build();
//                mAdView_2.loadAd(adRequest2);
//                AdRequest adRequest3 = new AdRequest.Builder().build();
//                mAdView_3.loadAd(adRequest3);
//                AdRequest adRequest4 = new AdRequest.Builder().build();
//                mAdView_4.loadAd(adRequest4);
//                AdRequest adRequest5 = new AdRequest.Builder().build();
//                mAdView_5.loadAd(adRequest5);
//                AdRequest adRequest6 = new AdRequest.Builder().build();
//                mAdView_6.loadAd(adRequest6);
//                AdRequest adRequest7 = new AdRequest.Builder().build();
//                mAdView_7.loadAd(adRequest7);

                mAdView.loadAd(adRequest);
                mAdView_1.loadAd(adRequest);
                mAdView_2.loadAd(adRequest);
                mAdView_3.loadAd(adRequest);
                mAdView_4.loadAd(adRequest);
                mAdView_5.loadAd(adRequest);
                mAdView_6.loadAd(adRequest);
                mAdView_7.loadAd(adRequest);
                mAdView_8.loadAd(adRequest);
                mAdView_9.loadAd(adRequest);


//                mAdView.destroy();
//                mAdView_1.destroy();
//                mAdView_2.destroy();
//                mAdView_3.destroy();
//                mAdView_4.destroy();
//                mAdView_5.destroy();
//                mAdView_6.destroy();
//                mAdView_7.destroy();
//                mAdView_8.destroy();
//                mAdView_9.destroy();
//                mAdView_10.destroy();
//                mAdView_11.destroy();
//                mAdView_12.destroy();
            }
        };
        /////////////////////定时器///////////////////////////////////////
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.switch1:
                    if (isChecked) {
//                        AdRequest adRequest = new AdRequest.Builder().build();
//                        mAdView.loadAd(adRequest);
                        handler.postDelayed(runnable, TIME);
                    }
                    else{
                        handler.removeCallbacks(runnable);
                        mAdView.destroy();
                        mAdView_1.destroy();
                        mAdView_2.destroy();
                        mAdView_3.destroy();
                        mAdView_4.destroy();
                        mAdView_5.destroy();
                        mAdView_6.destroy();
                        mAdView_7.destroy();
                        mAdView_8.destroy();
                        mAdView_9.destroy();


                    }
            }
        }

    }




}




