package giltwizy.hopedevelopers.com.eafya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    private static int SPLASH_TIMEOUT = 3000;
    Context context = this;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mp = MediaPlayer.create(context, R.raw.splash);
        mp.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mp.stop();
                mp.release();
                Intent loginIntent=new Intent(Splash.this, Age.class);
                startActivity(loginIntent);
                finish();
            }
        },SPLASH_TIMEOUT);
    }
}






