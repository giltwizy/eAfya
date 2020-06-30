package giltwizy.hopedevelopers.com.eafya;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class Icast extends AppCompatActivity {
    MediaPlayer mp;
    Context context = this;
    float x1, y1, x2, y2;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icast);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        ImageButton iCast = findViewById(R.id.ibAfyaTip);

        iCast.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(Icast.this, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    openIcastActivity();
                    vibrate();
                    return super.onDoubleTap(e);
                }

                @Override
                public boolean onSingleTapConfirmed(MotionEvent event) {
                    playIcastAudio();
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

    private void playIcastAudio() {
        mp = MediaPlayer.create(context, R.raw.i_cast);
        mp.start();
    }

    private void openIcastActivity() {
        Intent iCastActivity = new Intent(getApplicationContext(), IcastCommingSoon.class);
        startActivity(iCastActivity);
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
                    Intent i = new Intent(Icast.this, AfyaTip.class);
                    startActivity(i);
                } else if (x1 > x2) {
//                    go to the right activity
                    Intent i = new Intent(Icast.this, ElimuYaUzazi.class);
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