package giltwizy.hopedevelopers.com.eafya;

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

public class Icast extends AppCompatActivity {
    MediaPlayer mp;
    Context context = this;
    float x1, y1, x2, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icast);

        ImageButton iCast = findViewById(R.id.ibElimuYaUzazi);

        iCast.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(Icast.this, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    Intent iCastActivity = new Intent(getApplicationContext(), IcastCommingSoon.class);
                    startActivity(iCastActivity);
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
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
        System.exit(0);
    }
}