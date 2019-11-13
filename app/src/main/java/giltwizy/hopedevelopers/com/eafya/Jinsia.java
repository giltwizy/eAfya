package giltwizy.hopedevelopers.com.eafya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Timer;

public class Jinsia extends AppCompatActivity  {
    Context context = this;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinsia);

        LinearLayout ujinsia = findViewById(R.id.ujinsiaLayout);
        LinearLayout usafi = findViewById(R.id.usafiLayout);
//        RelativeLayout kutokwaNaDamu = findViewById(R.id.kutokwaNaDamuLayout);
//        RelativeLayout  daliliZaKuanzaHedhi = findViewById(R.id.dalliliZaKuanzaHedhiLayout);
//        hedhininini.setOnClickListener(this);
        mp = MediaPlayer.create(context, R.raw.elimu_ujinsia);
        mp.start();

        ujinsia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playUjinsia();
            }
        });

        usafi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playUsafi();
            }
        });

    }

    private void playUsafi() {
        mp = MediaPlayer.create(this,R.raw.elimu_ujinsia);
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
            } else {
                mp.start();
            }
        } catch(Exception e) { e.printStackTrace(); }
    }

    private void playUjinsia() {
        mp = MediaPlayer.create(this,R.raw.jinsi_jinsia);
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
            } else {
                mp.start();
            }
        } catch(Exception e) { e.printStackTrace(); }
    }


}
