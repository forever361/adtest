package adloading.kun.com.adall;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardedVideoAd;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private Button cybutton;
    private Button bannerbutton;
    private Button otherpage;
    private Button page001;
    private AdView mAdView;
    private AdView mAdView_xb;
    private AdView mAdView_zn;
    private AdView mAdView_001;
    private AdView mAdView_cy;
    private AdView mAdView_js;
    private InterstitialAd mInterstitialAd;
    private Switch mSwith;
    private Switch mSwith1;
    private Switch mSwith2;
    private Switch mSwith3;
    private Switch mSwith4;
    private Switch mSwith5;
    private int TIME;  //随机时间.
    private RewardedVideoAd mRewardedVideoAd;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        cybutton = (Button) findViewById(R.id.button);
        bannerbutton = (Button) findViewById(R.id.button2);
        otherpage=(Button) findViewById(R.id.button3);
        page001=(Button) findViewById(R.id.button4);

        mSwith = (Switch) findViewById(R.id.switchPage);
        mSwith1 = (Switch) findViewById(R.id.switchPage1);
        mSwith2 = (Switch) findViewById(R.id.switchPage2);
        mSwith3 = (Switch) findViewById(R.id.switchPage3);
        mSwith4 = (Switch) findViewById(R.id.switchPage4);
        mSwith5 = (Switch) findViewById(R.id.switchPage5);

        ClickListener listener_bu = new ClickListener();
        cybutton.setOnClickListener(listener_bu);
        bannerbutton.setOnClickListener(listener_bu);
        otherpage.setOnClickListener(listener_bu);
        page001.setOnClickListener(listener_bu);

        CheckBoxListener listener = new CheckBoxListener();
        mSwith.setOnCheckedChangeListener(listener);

        CheckBoxListener1 listener1 = new CheckBoxListener1();
        mSwith1.setOnCheckedChangeListener(listener1);

        CheckBoxListener2 listener2 = new CheckBoxListener2();
        mSwith2.setOnCheckedChangeListener(listener2);

        CheckBoxListener3 listener3 = new CheckBoxListener3();
        mSwith3.setOnCheckedChangeListener(listener3);

        CheckBoxListener4 listener4 = new CheckBoxListener4();
        mSwith4.setOnCheckedChangeListener(listener4);

        CheckBoxListener5 listener5 = new CheckBoxListener5();
        mSwith5.setOnCheckedChangeListener(listener5);

        mAdView_xb = findViewById(R.id.adView_xb);
        mAdView_zn = findViewById(R.id.adView_zn);
        mAdView_001 = findViewById(R.id.adView_001);
        mAdView_cy = findViewById(R.id.adView_cy);
        mAdView_js = findViewById(R.id.adView_js);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4855871441281679/8185021095");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



    }

    class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
//                    Toast.makeText(getApplicationContext(), "button test", Toast.LENGTH_SHORT).show();
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        mInterstitialAd.setAdListener(new AdListener() {
                            @Override
                            public void onAdClosed() {
                                // Load the next interstitial.
                                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                            }
                        });
                    }
//                    if (mInterstitialAd.isLoaded()){
//                        Timer timer = new Timer();
//                        TimerTask timerTask = new TimerTask() {
//                            @Override
//                            public void run() {
//                                try{
//                                    Runtime runtime=Runtime.getRuntime();
//                                    runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
//                                }catch(IOException e){
//                                    Log.e("Exception when doBack", e.toString());
//                                }
//                            }
//                        };
//                        timer.schedule(timerTask,5000);}
                    break;
//
//
//                try {
//                        Thread.currentThread().sleep(10000);//阻断2秒
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                try{
//                        Runtime runtime=Runtime.getRuntime();
//                        runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
//                    }catch(IOException e){
//                        Log.e("Exception when doBack", e.toString());
//                    }

                case R.id.button2:
                    AdRequest adRequest = new AdRequest.Builder().build();
                    mAdView_xb.destroy();
                    mAdView_xb.loadAd(adRequest);
                    break;

                case R.id.button3:
                    Intent i = new Intent(MainActivity.this ,otherpage.class);
                    startActivity(i);
                    break;

                case R.id.button4:
                    Intent i1 = new Intent(MainActivity.this ,page001.class);
                    startActivity(i1);
                    break;
            }

        }
    }


    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        /////////////////////定时器///////////////////////////////////////
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int TIME = (int)((Math.random() * 6 + 0.5)*10000)-737;
                handler.postDelayed(this, TIME);
                Toast.makeText(MainActivity.this, String.valueOf(TIME), Toast.LENGTH_SHORT).show();
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView_xb.loadAd(adRequest);
                mAdView_xb.destroy();
            }
        };
        /////////////////////定时器///////////////////////////////////////
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.switchPage:
                    if (isChecked) {
//                        AdRequest adRequest = new AdRequest.Builder().build();
//                        mAdView.loadAd(adRequest);
                        handler.postDelayed(runnable, TIME);
                    }
                    else{
                        handler.removeCallbacks(runnable);
                        mAdView_xb.destroy();
                    }
            }
        }

    }

    class CheckBoxListener1 implements CompoundButton.OnCheckedChangeListener {
        Handler handler1 = new Handler();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                int TIME = (int)((Math.random() * 6 + 0.5)*10000)-737;
                handler1.postDelayed(this, TIME);
                Toast.makeText(MainActivity.this, String.valueOf(TIME), Toast.LENGTH_SHORT).show();
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView_zn.loadAd(adRequest);
                mAdView_zn.destroy();
            }
        };
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.switchPage1:
                    if (isChecked) {
//                        AdRequest adRequest = new AdRequest.Builder().build();
//                        mAdView_xb.loadAd(adRequest);
                        handler1.postDelayed(runnable1, TIME);
                    }
                    else{
                        handler1.removeCallbacks(runnable1);
                        mAdView_zn.destroy();
                    }
            }
        }


    }

    class CheckBoxListener2 implements CompoundButton.OnCheckedChangeListener {
        Handler handler2 = new Handler();
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                int TIME = (int) ((Math.random() * 6 + 0.5) * 10000) - 737;
                handler2.postDelayed(this, TIME);
                Toast.makeText(MainActivity.this, String.valueOf(TIME), Toast.LENGTH_SHORT).show();
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView_001.loadAd(adRequest);
                mAdView_001.destroy();
            }
        };

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.switchPage2:
                    if (isChecked) {
//                        AdRequest adRequest = new AdRequest.Builder().build();
//                        mAdView_xb.loadAd(adRequest);
                        handler2.postDelayed(runnable2, TIME);
                    } else {
                        handler2.removeCallbacks(runnable2);
                        mAdView_001.destroy();
                    }
            }
        }
    }

    class CheckBoxListener3 implements CompoundButton.OnCheckedChangeListener {
        Handler handler3 = new Handler();
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                int TIME = (int)((Math.random() * 6 + 0.5)*10000)-737;
                handler3.postDelayed(this, TIME);
                Toast.makeText(MainActivity.this, String.valueOf(TIME), Toast.LENGTH_SHORT).show();
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView_cy.loadAd(adRequest);
                mAdView_cy.destroy();
            }
        };
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.switchPage3:
                    if (isChecked) {
//                        AdRequest adRequest = new AdRequest.Builder().build();
//                        mAdView_xb.loadAd(adRequest);
                        handler3.postDelayed(runnable3, TIME);
                    }
                    else{
                        handler3.removeCallbacks(runnable3);
                        mAdView_cy.destroy();
                    }
            }
        }

    }

    class CheckBoxListener4 implements CompoundButton.OnCheckedChangeListener {
        Handler handler4 = new Handler();
        Runnable runnable4 = new Runnable() {
            @Override
            public void run() {
                int TIME = (int)((Math.random() * 6 + 0.5)*10000)-737;
                handler4.postDelayed(this, TIME);
                Toast.makeText(MainActivity.this, String.valueOf(TIME), Toast.LENGTH_SHORT).show();
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView_js.loadAd(adRequest);
                mAdView_js.destroy();
            }
        };
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.switchPage4:
                    if (isChecked) {
//                        AdRequest adRequest = new AdRequest.Builder().build();
//                        mAdView_xb.loadAd(adRequest);
                        handler4.postDelayed(runnable4, TIME);
                    }
                    else{
                        handler4.removeCallbacks(runnable4);
                        mAdView_js.destroy();
                    }
            }
        }

    }

    class CheckBoxListener5 implements CompoundButton.OnCheckedChangeListener {
        Handler handler5 = new Handler();
        Runnable runnable5 = new Runnable() {
            @Override
            public void run() {
                int TIME = (int)((Math.random() * 6 + 0.5)*10000)-737;
//                int TIME =10000;
                handler5.postDelayed(this, TIME);
                Toast.makeText(MainActivity.this, "插页："+String.valueOf(TIME), Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            // Load the next interstitial.
                            mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        }
                    });
                }
/////////////////////////////////延时去执行返回按钮//////////////////////////////////
                if (mInterstitialAd != null && mInterstitialAd.isLoaded()){
                    Timer timer = new Timer();
                    TimerTask timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            try{
                                Runtime runtime=Runtime.getRuntime();
                                runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
                            }catch(IOException e){
                                Log.e("Exception when doBack", e.toString());
                            }
                        }
                    };
                    timer.schedule(timerTask,3000);}
/////////////////////////////////延时去执行返回按钮//////////////////////////////////
            }
        };
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.switchPage5:
                    if (isChecked) {
                        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                            mInterstitialAd.setAdListener(new AdListener() {
                                @Override
                                public void onAdClosed() {
                                    // Load the next interstitial.
                                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                }
                            });
                        }

                        handler5.postDelayed(runnable5, TIME);
                    }
                    else{
                        handler5.removeCallbacks(runnable5);
                    }

            }
        }

    }




}

