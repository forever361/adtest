package adloading.kun.com.adall;

/**
 * Created by Administrator on 2018/3/27 0027.
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardedVideoAd;


public class otherpage extends AppCompatActivity {



    private Button mbutton1;
    private Button mbutton2;
    private Button mbutton3;
    private Button mbutton4;
    private Button mbutton5;
    private Button mbutton6;
    private Button mbutton7;
    private Button mbutton8;
    private Button mbutton9;
    private Button mbutton10;


    private InterstitialAd mInterstitialAd;
    private Switch mSwith;
    private int TIME;  //随机时间.
    private RewardedVideoAd mRewardedVideoAd;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_page);
        initView();
    }

    private void initView() {


        mbutton1 = (Button) findViewById(R.id.button1);
        mbutton2 = (Button) findViewById(R.id.button2);
        mbutton3 = (Button) findViewById(R.id.button3);
        mbutton4 = (Button) findViewById(R.id.button4);
        mbutton5 = (Button) findViewById(R.id.button5);
        mbutton6 = (Button) findViewById(R.id.button6);
        mbutton7 = (Button) findViewById(R.id.button7);
        mbutton8 = (Button) findViewById(R.id.button8);
        mbutton9 = (Button) findViewById(R.id.button9);
        mbutton10 = (Button) findViewById(R.id.button10);


        ClickListener listener = new ClickListener();
        mbutton1.setOnClickListener(listener);
        mbutton2.setOnClickListener(listener);
        mbutton3.setOnClickListener(listener);
        mbutton4.setOnClickListener(listener);
        mbutton5.setOnClickListener(listener);
        mbutton6.setOnClickListener(listener);
        mbutton7.setOnClickListener(listener);
        mbutton8.setOnClickListener(listener);
        mbutton9.setOnClickListener(listener);
        mbutton10.setOnClickListener(listener);


    }


        class ClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        Intent i1 = new Intent(otherpage.this ,page001.class);
                        startActivity(i1);

                        break;


                    case R.id.button2:
                        Intent i2 = new Intent(otherpage.this ,xueba.class);
                        startActivity(i2);

                        break;

                    case R.id.button3:
                        Intent i3 = new Intent(otherpage.this ,zhinanzhen.class);
                        startActivity(i3);

                        break;

                    case R.id.button4:
                        Intent i4 = new Intent(otherpage.this ,chengyu.class);
                        startActivity(i4);

                        break;

                    case R.id.button5:
                        Intent i5 = new Intent(otherpage.this ,jisuanqi.class);
                        startActivity(i5);

                        break;

                    case R.id.button6:
                        Intent i6 = new Intent(otherpage.this ,xuehuahau3.class);
                        startActivity(i6);

                        break;
                }

            }
        }








}




