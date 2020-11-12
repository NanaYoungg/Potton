package com.example.potton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class SplashActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = (ImageView)findViewById(R.id.splash_gif);

        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(imageView);

        Glide.with(this).load(R.drawable.door).into(gifImage);

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 3000);

    }

    private class splashhandler implements  Runnable{
        public void run(){

            startActivity(new Intent(getApplication(), MainActivity.class));
            SplashActivity.this.finish(); // 로딩페이지 Activity stack에서 제거

        }
    }

    public void onBackPressed() {
        //스플래시 화면에서 넘어갈때 뒤로가기 버튼 못누르게 함
    }
}