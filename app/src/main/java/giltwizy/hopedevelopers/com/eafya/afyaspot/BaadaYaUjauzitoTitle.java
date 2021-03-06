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

import giltwizy.hopedevelopers.com.eafya.ElimuYaUzazi;
import giltwizy.hopedevelopers.com.eafya.R;

public class BaadaYaUjauzitoTitle extends AppCompatActivity {

    MediaPlayer mp;
    Context context = this;
    Vibrator vibrator;

    float x1, y1, x2, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baada_ya_ujauzito_title);

        ImageButton baadaYaUjauzitoTitle = findViewById(R.id.ibBaadaYaUjauzito);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        baadaYaUjauzitoTitle.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(BaadaYaUjauzitoTitle.this, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    openBaadaYaUjauzitoActivity();
                    vibrate();
                    Log.d("DoubleTap","BaadaYaUjauzito imageButton");
                    return super.onDoubleTap(e);
                }

                @Override
                public boolean onSingleTapConfirmed(MotionEvent event) {
                    playBaadaYaUjauzitoAudio();
                    Log.d("SingleTap", "BaadaYaUjauzito imageButton");
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

    private void playBaadaYaUjauzitoAudio() {
        mp = MediaPlayer.create(context, R.raw.baada_ya_ujauzito);
        mp.start();
    }

    private void openBaadaYaUjauzitoActivity() {
        Intent baadaYaUjauzitoActivity = new Intent(getApplicationContext(), BaadaYaUjauzito.class);
        startActivity(baadaYaUjauzitoActivity);
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
                    Intent i = new Intent(BaadaYaUjauzitoTitle.this, WakatiWaUjauzitoTitle.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                } else if (x1 > x2) {
//                    go to the right activity
                    Intent i = new Intent(BaadaYaUjauzitoTitle.this, KablaYaUjauzitoTitle.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                break;
        }
        return false;
    }


}