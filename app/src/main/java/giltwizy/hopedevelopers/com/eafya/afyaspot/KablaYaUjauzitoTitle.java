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

public class KablaYaUjauzitoTitle extends AppCompatActivity {

    MediaPlayer mp;
    Context context = this;

    private Vibrator vibrator;

    float x1, y1, x2, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabla_ya_ujauzito_title);

        ImageButton kablaYaUjauzito = findViewById(R.id.ibKablaYaUjauzito);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        kablaYaUjauzito.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(KablaYaUjauzitoTitle.this, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    openKablaYaUjauzito();
                    vibration();
                    return super.onDoubleTap(e);
                }

                @Override
                public boolean onSingleTapConfirmed(MotionEvent event) {
                    mp = MediaPlayer.create(context, R.raw.taarifa_kabla_ya_ujauzito);
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

    private void openKablaYaUjauzito() {
        Intent kablaYaUjauzitoActivity = new Intent(getApplicationContext(), KablaYaUjauzito.class);
        startActivity(kablaYaUjauzitoActivity);
    }

    private void vibration() {
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
                    Intent i = new Intent(KablaYaUjauzitoTitle.this, BaadaYaUjauzitoTitle.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                } else if (x1 > x2) {
//                    go to the right activity
                    Intent i = new Intent(KablaYaUjauzitoTitle.this, WakatiWaUjauzitoTitle.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                break;
        }
        return false;
    }


}