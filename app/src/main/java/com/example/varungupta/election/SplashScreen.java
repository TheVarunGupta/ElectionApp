package com.example.varungupta.election;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    Thread splashTread;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        StartAnimations();

    }
    private void StartAnimations() {

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.slide);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashScreen.this, loginScreen.class);
                    startActivity(intent);
                    SplashScreen.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);


                } catch (InterruptedException e) {
                } finally {
                    SplashScreen.this.finish();

                }

            }
        };
        splashTread.start();


    }
}