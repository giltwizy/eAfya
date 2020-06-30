package giltwizy.hopedevelopers.com.eafya.afyaspot;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import giltwizy.hopedevelopers.com.eafya.R;

public class WakatiWaUjauzitoTitle extends AppCompatActivity {

    MediaPlayer mp;
    Context context = this;
    private Vibrator vibrator;

    float x1, y1, x2, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wakati_wa_ujauzito_title);

        ImageButton wakatiWaUjauzitoTitle = findViewById(R.id.ibWakatiWaUjauzito);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        wakatiWaUjauzitoTitle.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(WakatiWaUjauzitoTitle.this, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    openWakatiWaUjauzitoActivity();
                    vibrate();
                    Log.d("DoubleTap","WakatiWaUjauzito ImageButton");
                    return super.onDoubleTap(e);
                }

                @Override
                public boolean onSingleTapConfirmed(MotionEvent event) {
                    playWakatiWaUjauzitoAudio();
                    Log.d("SingleTap", "WakatiWaUjauzito ImageButton");
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

    private void playWakatiWaUjauzitoAudio() {
        mp = MediaPlayer.create(context, R.raw.kipindi_cha_ujauzito);
        mp.start();
    }

    private void openWakatiWaUjauzitoActivity() {
        Intent wakatiWaUjauzitoActivity = new Intent(getApplicationContext(), WakatiWaUjauzito.class);
        startActivity(wakatiWaUjauzitoActivity);
    }

    private void vibrate() {
        vibrator.vibrate(100);
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
                    Intent i = new Intent(WakatiWaUjauzitoTitle.this, KablaYaUjauzitoTitle.class);
                    startActivity(i);
                } else if (x1 > x2) {
//                    go to the right activity
                    Intent i = new Intent(WakatiWaUjauzitoTitle.this, BaadaYaUjauzitoTitle.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }
}