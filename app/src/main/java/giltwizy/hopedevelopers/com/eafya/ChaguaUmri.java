package giltwizy.hopedevelopers.com.eafya;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChaguaUmri extends AppCompatActivity {
    MediaPlayer mp;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chagua_umri);

        TextView Umri10hadi14 = findViewById(R.id.umriKuminaKumiNaNne);
        Button rudiNyuma = findViewById(R.id.rudiNyuma);

        mp = MediaPlayer.create(context, R.raw.sajili_umri);
        mp.start();

        Umri10hadi14.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(ChaguaUmri.this, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    Intent hedhiActivity = new Intent(getApplicationContext(), KablaYaUjauzito.class);
                    startActivity(hedhiActivity);
//                    Toast.makeText(getApplicationContext(), "onDoubleTap", Toast.LENGTH_SHORT).show();
//                    hedhi(nView);
                    return super.onDoubleTap(e);
                }

                @Override
                public boolean onSingleTapConfirmed(MotionEvent event) {
                    mp = MediaPlayer.create(context, R.raw.miaka_kumi_na_kumiananne);
                    mp.start();
//                    Toast.makeText(getApplicationContext(), "onSingleTap", Toast.LENGTH_SHORT).show();
                    Log.d("onSingleTapConfirmed", "onSingleTap");
                    return false;
                }
            });

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                gestureDetector.onTouchEvent(event);
                return true;
            }
        });

        rudiNyuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                mp = MediaPlayer.create(context, R.raw.sitisha);
                mp.start();
            }
        });


    }
}
