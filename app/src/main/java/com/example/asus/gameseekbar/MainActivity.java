package com.example.asus.gameseekbar;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tv_Diem;
    private CheckBox cb_1, cb_2, cb_3;
    private SeekBar sb_1, sb_2, sb_3;
    private Button btn_play;
    private int diem = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        DisablSeekbar();
        tv_Diem.setText(diem + "");
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
//                tao random
                int number =5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                //                kiem tra seetbar =100 wwin
                //1 wwin
                if(sb_1.getProgress()>= sb_1.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "1 win", Toast.LENGTH_SHORT).show();
                    btn_play.setVisibility(View.VISIBLE);
                    if(cb_1.isChecked()){
                        diem= diem +10;
//                        diem +=10;
                        Toast.makeText(MainActivity.this, "Chuc Mung cong 10 Diem: ", Toast.LENGTH_SHORT).show();
                    }else {
                        diem = diem-10;
                        Toast.makeText(MainActivity.this, "Sai Cmnr tru 10 diem", Toast.LENGTH_SHORT).show();
                    }
                    tv_Diem.setText(diem + "");
                    EnableCheckBox();
                }
                //2 win
                if(sb_2.getProgress()>= sb_2.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "2 win", Toast.LENGTH_SHORT).show();
                    btn_play.setVisibility(View.VISIBLE);
                    if(cb_2.isChecked()){
                        diem= diem +10;
//                        diem +=10;
                        Toast.makeText(MainActivity.this, "Chuc Mung cong 10 diem", Toast.LENGTH_SHORT).show();
                    }else {
                        diem = diem-10;
                        Toast.makeText(MainActivity.this, "Sai Cmnr tru 10 diem", Toast.LENGTH_SHORT).show();
                    }
                    tv_Diem.setText(diem + "");
                    EnableCheckBox();
                }
                //3 win
                if(sb_3.getProgress()>= sb_3.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "3 win", Toast.LENGTH_SHORT).show();
                    btn_play.setVisibility(View.VISIBLE);
                    if(cb_3.isChecked()){
                        diem= diem +10;
//                        diem +=10;
                        Toast.makeText(MainActivity.this, "Chuc Mung cong 10 diem", Toast.LENGTH_SHORT).show();
                    }else {
                        diem = diem-10;
                        Toast.makeText(MainActivity.this, "Sai Cmnr tru 10 diem", Toast.LENGTH_SHORT).show();
                    }
                    tv_Diem.setText(diem + "");
                    EnableCheckBox();
                }
//                cong du lieu random vao
                sb_1.setProgress(sb_1.getProgress()+one);
                sb_2.setProgress(sb_2.getProgress()+two);
                sb_3.setProgress(sb_3.getProgress()+three);

            }

            @Override
            public void onFinish() {

            }
        };
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_1.isChecked() || cb_2.isChecked() || cb_3.isChecked()){
                    //an button
                    btn_play.setVisibility(view.INVISIBLE);
                    sb_1.setProgress(0);
                    sb_2.setProgress(0);
                    sb_3.setProgress(0);
                    countDownTimer.start();
                    DisableCheckBox();

                }else {
                    Toast.makeText(MainActivity.this, "Vui Long Dat Cuoc", Toast.LENGTH_SHORT).show();
                }


            }
        });

        cb_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb_2.setChecked(false);
                    cb_3.setChecked(false);
                }
            }
        });
        cb_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb_1.setChecked(false);
                    cb_3.setChecked(false);
                }
            }
        });
        cb_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb_2.setChecked(false);
                    cb_1.setChecked(false);
                }
            }
        });
    }
    private void initView() {
        tv_Diem = (TextView) findViewById(R.id.tv_score);
        cb_1 = (CheckBox) findViewById(R.id.checkBox);
        cb_2 = (CheckBox) findViewById(R.id.checkBox2);
        cb_3 = (CheckBox) findViewById(R.id.checkBox3);
        sb_1 = (SeekBar) findViewById(R.id.seekBar);
        sb_2 = (SeekBar) findViewById(R.id.seekBar2);
        sb_3 = (SeekBar) findViewById(R.id.seekBar3);
        btn_play = (Button) findViewById(R.id.btn_play);


    }
    private void EnableCheckBox(){
        cb_1.setEnabled(true);
        cb_2.setEnabled(true);
        cb_3.setEnabled(true);
    }
    private void DisableCheckBox(){
        cb_1.setEnabled(false);
        cb_2.setEnabled(false);
        cb_3.setEnabled(false);
    }

  
    private void DisablSeekbar(){
        sb_1.setEnabled(false);
        sb_2.setEnabled(false);
        sb_3.setEnabled(false);

    }

}
