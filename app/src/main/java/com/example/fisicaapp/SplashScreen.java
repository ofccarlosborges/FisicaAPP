package com.example.fisicaapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {


    TextView textSplash;
    Animation animSuperior, animInferior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
        textSplash = findViewById(R.id.textSplash);
        animSuperior = AnimationUtils.loadAnimation(this, R.anim.anim_superior);
        animInferior = AnimationUtils.loadAnimation(this, R.anim.anim_inferior);

        textSplash.setAnimation(animInferior);
    }
}

