package com.example.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 지연 : 배경음악 객체
    private static MediaPlayer mp;
    // 지연 : 배경음악 설정
    // 지연 : 홈버튼 누를때 음악 종료
    @Override
    protected void onUserLeaveHint(){
        mp.pause();
        super.onUserLeaveHint();
    }
    @Override
    public void onResume(){
        mp.start();
        super.onResume();
    }
    @Override
    public void onDestroy(){
        mp.stop();
        super.onDestroy();
    }
    @Override
    public void onBackPressed(){
        mp.stop();
        super.onBackPressed();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 지연 : 타이틀 바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // 지연 : 배경음악시작
        mp = MediaPlayer.create(this, R.raw.main_music);
        mp.setLooping(true); // 반복여부
        mp.start();

        // 두 버튼 연결
        Button main_btn1 = (Button) findViewById(R.id.main_btn1);
        Button main_btn2 = (Button) findViewById(R.id.main_btn2);
        // 지연 배경 반짝임 객체 연결
        ImageView blink1=(ImageView)findViewById(R.id.blink);
        ImageView blink2=(ImageView)findViewById(R.id.blink2);
        ImageView blink3=(ImageView)findViewById(R.id.blink3);
        // 지연 : blink 애니메이션
        Animation mAnimation = new AlphaAnimation(1, 0);
        mAnimation.setDuration(800);
        mAnimation.setInterpolator(new LinearInterpolator());
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.REVERSE);
        //애니메이션 시작
        blink1.startAnimation(mAnimation);
        blink2.startAnimation(mAnimation);
        blink3.startAnimation(mAnimation);

        // 새 게임 버튼 누르면
        main_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "액티비티 전환", Toast.LENGTH_LONG).show();
                // 액티비티 전환 코드
                Intent intent = new Intent(getApplicationContext(), NewGameActivity.class);
                startActivity(intent);
            }
        });

        // 불러오기 버튼 누르면
        main_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "액티비티 전환", Toast.LENGTH_LONG).show();
                // 액티비티 전환 코드
                Intent intent = new Intent(getApplicationContext(), NewGameActivity.class);
                startActivity(intent);
            }
        });
    }

}
