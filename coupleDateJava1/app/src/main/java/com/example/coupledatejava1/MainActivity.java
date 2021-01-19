package com.example.coupledatejava1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private String[] achievement = {"100일 되기", "200일 되기", "300일 되기", "400일 되기", "500일 되기", "600일 되기", "700일 되기", "800일 되기", "900일 되기", "1000일 되기"};
    private String[] achievementOri = {"100일 되기", "200일 되기", "300일 되기", "400일 되기", "500일 되기", "600일 되기", "700일 되기", "800일 되기", "900일 되기", "1000일 되기"};

    private int date, startNum, endNum;

    private String nowTime;

    private TextView achievementTv, dateTv, startNumTv, endNumTv;
    private ProgressBar statusPb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        ActionBar actionBar;

        actionBar = getSupportActionBar();
        actionBar.hide();

        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        nowTime = sdfNow.format(new Date(System.currentTimeMillis()));

        achievementTv = (TextView)findViewById(R.id.achievementTv);
        dateTv = (TextView)findViewById(R.id.dateTv);
        startNumTv = (TextView)findViewById(R.id.startNumTv);
        endNumTv = (TextView)findViewById(R.id.endNumTv);

        statusPb = (ProgressBar) findViewById(R.id.statusPb);

        achievementTv.setText(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", achievement[0], achievement[1], achievement[2], achievement[3], achievement[4], achievement[5], achievement[6], achievement[7], achievement[8], achievement[9]));

        handler.sendEmptyMessage(0);
    }

    private int getTime() {
        SimpleDateFormat sdfNow1 = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfNow2 = new SimpleDateFormat("MM");
        SimpleDateFormat sdfNow3 = new SimpleDateFormat("dd");
        SimpleDateFormat sdfNow4 = new SimpleDateFormat("HH");
        SimpleDateFormat sdfNow5 = new SimpleDateFormat("mm");
        SimpleDateFormat sdfNow6 = new SimpleDateFormat("ss");

        int sdfNowI1, sdfNowI2, sdfNowI3, sdfNowI4, sdfNowI5, sdfNowI6;
        date = 0;

        sdfNowI1 = Integer.parseInt(sdfNow1.format(new Date(System.currentTimeMillis())));
        sdfNowI2 = Integer.parseInt(sdfNow2.format(new Date(System.currentTimeMillis())));
        sdfNowI3 = Integer.parseInt(sdfNow3.format(new Date(System.currentTimeMillis())));
        sdfNowI4 = Integer.parseInt(sdfNow4.format(new Date(System.currentTimeMillis())));
        sdfNowI5 = Integer.parseInt(sdfNow5.format(new Date(System.currentTimeMillis())));
        sdfNowI6 = Integer.parseInt(sdfNow6.format(new Date(System.currentTimeMillis())));

        if ((2021 - sdfNowI1) > 0) {
            date = date + 365 * (2021 - sdfNowI1);
        }

        if (sdfNowI2 == 2) {
            date = date + 31;
        } else if (sdfNowI2 == 3) {
            date = date + 59;
        } else if (sdfNowI2 == 4) {
            date = date + 90;
        } else if (sdfNowI2 == 5) {
            date = date + 120;
        } else if (sdfNowI2 == 6) {
            date = date + 151;
        } else if (sdfNowI2 == 7) {
            date = date + 181;
        } else if (sdfNowI2 == 8) {
            date = date + 212;
        } else if (sdfNowI2 == 9) {
            date = date + 243;
        } else if (sdfNowI2 == 0) {
            date = date + 273;
        } else if (sdfNowI2 == 11) {
            date = date + 304;
        } else if (sdfNowI2 == 12) {
            date = date + 334;
        }

        date = date + sdfNowI3;

        // 계산 끝

        for (int i = 0; i < 10; i++) { // ✔
            achievement[i] = String.format("%s X", achievementOri[i]);
        }

        if (date < 100 && date >= 0) {
            startNum = 0;
            endNum = 100;
        } else if (date < 200 && date >= 100) {
            startNum = 100;
            endNum = 200;

            changeStatus(1);
        } else if (date < 300 && date >= 200) {
            startNum = 200;
            endNum = 300;

            changeStatus(2);
        } else if (date < 400 && date >= 300) {
            startNum = 300;
            endNum = 400;

            changeStatus(3);
        } else if (date < 500 && date >= 400) {
            startNum = 400;
            endNum = 500;

            changeStatus(4);
        } else if (date < 600 && date >= 500) {
            startNum = 500;
            endNum = 600;

            changeStatus(5);
        } else if (date < 700 && date >= 600) {
            startNum = 600;
            endNum = 700;

            changeStatus(6);
        } else if (date < 800 && date >= 700) {
            startNum = 700;
            endNum = 800;

            changeStatus(7);
        } else if (date < 900 && date >= 800) {
            startNum = 800;
            endNum = 900;

            changeStatus(8);
        } else if (date < 1000 && date >= 900) {
            startNum = 900;
            endNum = 1000;

            changeStatus(9);
        } else if (date >= 1000) {
            startNum = 1000;
            endNum = 2000;

            changeStatus(10);
        }

        achievementTv.setText(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", achievement[0], achievement[1], achievement[2], achievement[3], achievement[4], achievement[5], achievement[6], achievement[7], achievement[8], achievement[9]));

        startNumTv.setText(Integer.toString(startNum));
        endNumTv.setText(Integer.toString(endNum));

        dateTv.setText(Integer.toString(date) + " 일");

        statusPb.setProgress(Math.round((date - startNum) * 100 / (endNum - startNum)));

        return date;
    }

    private void changeStatus(int j) {
        for (int i = 0; i < j; i++) { // ✔
            achievement[i] = String.format("%s ✔", achievementOri[i]);
        }
    }

    Handler handler = new Handler() {

        @Override
        public void handleMessage(@NonNull Message msg) {
            Log.d("DATE", Integer.toString(getTime()));
            handler.sendEmptyMessage(0);
        }
    };
}