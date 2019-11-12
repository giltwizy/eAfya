package giltwizy.hopedevelopers.com.eafya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Hedhi extends AppCompatActivity implements View.OnClickListener {
    Context context = this;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hedhi);

        LinearLayout hedhininini = findViewById(R.id.hedhiLayout);
        LinearLayout kalenda = findViewById(R.id.kalendaLayout);
        RelativeLayout kutokwaNaDamu = findViewById(R.id.kutokwaNaDamuLayout);
        RelativeLayout  daliliZaKuanzaHedhi = findViewById(R.id.dalliliZaKuanzaHedhiLayout);
//        hedhininini.setOnClickListener(this);
        mp = MediaPlayer.create(this,R.raw.test);

//        hedhininini.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    if (mp.isPlaying()) {
//                        mp.stop();
//                        mp.release();
//                        mp = MediaPlayer.create(context, R.raw.test);
//                    } else {
//                        mp.start();
//                    }
//                } catch(Exception e) { e.printStackTrace(); }
//
//            }
//        });






    }



    public void onClick(View view){
        try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.test);
                    } else {
                        mp.start();
                    }
                } catch(Exception e) { e.printStackTrace(); }

    }
}
