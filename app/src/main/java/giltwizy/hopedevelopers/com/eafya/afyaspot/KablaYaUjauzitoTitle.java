package giltwizy.hopedevelopers.com.eafya.afyaspot;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import giltwizy.hopedevelopers.com.eafya.ElimuYaUzazi;
import giltwizy.hopedevelopers.com.eafya.R;

public class KablaYaUjauzitoTitle extends AppCompatActivity {

    MediaPlayer mp;
    Context context = this;

    float x1, y1, x2, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabla_ya_ujauzito_title);

        ImageButton kablaYaUjauzitoTitle = findViewById(R.id.ibBaadaYaUjauzitoTitle);

        kablaYaUjauzitoTitle.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(KablaYaUjauzitoTitle.this, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    Intent kablaYaUjauzitoActivity = new Intent(getApplicationContext(), KablaYaUjauzito.class);
                    startActivity(kablaYaUjauzitoActivity);
//                    Toast.makeText(getApplicationContext(), "onDoubleTap", Toast.LENGTH_SHORT).show();
//                    hedhi(nView);
                    return super.onDoubleTap(e);
                }

                @Override
                public boolean onSingleTapConfirmed(MotionEvent event) {
                    mp = MediaPlayer.create(context, R.raw.kabla_ya_ujauzito);
                    mp.start();
//                    Toast.makeText(getApplicationContext(), "onSingleTap", Toast.LENGTH_SHORT).show();
                    Log.d("onSingleTapConfirmed", "Baada ya ujauzito");

                    return false;
                }
            });

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                gestureDetector.onTouchEvent(event);
                return true;
            }
        });

    }

    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2) {
//                    go to the left activity
                    Intent i = new Intent(KablaYaUjauzitoTitle.this, BaadaYaUjauzitoTitle.class);
                    startActivity(i);
                } else if (x1 > x2) {
//                    go to the right activity
                    Intent i = new Intent(KablaYaUjauzitoTitle.this, WakatiWaUjauzitoTitle.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Intent elimuYaUzaziActivity = new Intent(KablaYaUjauzitoTitle.this, ElimuYaUzazi.class);
        startActivity(elimuYaUzaziActivity);
    }
}