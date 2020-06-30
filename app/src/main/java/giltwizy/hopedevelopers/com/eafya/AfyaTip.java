package giltwizy.hopedevelopers.com.eafya;

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

public class AfyaTip extends AppCompatActivity {
    MediaPlayer mp;
    Context context = this;
    float x1, x2, y1, y2;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afya_tip);

        ImageButton afyaTip = findViewById(R.id.ibAfyaTip);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        afyaTip.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(AfyaTip.this, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    openAfyaTipCommingSoonActivity();
                    vibrate();
                    Log.d("DoubleTap", "AfyaTip imageButton");
                    return super.onDoubleTap(e);
                }

                @Override
                public boolean onSingleTapConfirmed(MotionEvent event) {
                    playAfyaTipsAudio();
                    Log.d("SingleTap", "AfyaTip imageButton");
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

    private void vibrate() {
        vibrator.vibrate(100);
    }

    private void playAfyaTipsAudio() {
        mp = MediaPlayer.create(context, R.raw.afya_tips);
        mp.start();
    }

    private void openAfyaTipCommingSoonActivity() {
        Intent afyaTipCommingSoonActivity = new Intent(getApplicationContext(), AfyaTipsCommingSoon.class);
        startActivity(afyaTipCommingSoonActivity);
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
                    Intent i = new Intent(AfyaTip.this, ElimuYaUzazi.class);
                    startActivity(i);
                } else if (x1 > x2) {
//                    go to the right activity
                    Intent i = new Intent(AfyaTip.this, Icast.class);
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