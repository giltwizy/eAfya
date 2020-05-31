package giltwizy.hopedevelopers.com.eafya;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView kablaYaUjauzito = findViewById(R.id.kablaYaUjauzitoCardView);
//        CardView hiv = findViewById(R.id.hivCardView);

        kablaYaUjauzito.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {
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
                    mp = MediaPlayer.create(context, R.raw.kipindi_kabla_ya_ujauzito);
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

//        hiv.setOnTouchListener(new View.OnTouchListener() {
//            private GestureDetector gestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {
//                @Override
//                public boolean onDoubleTap(MotionEvent e) {
//                    Intent hivActivity = new Intent(getApplicationContext(),Hiv.class);
//                    startActivity(hivActivity);
////                    Toast.makeText(getApplicationContext(), "onDoubleTap", Toast.LENGTH_SHORT).show();
////                    hedhi(nView);
//                    return super.onDoubleTap(e);
//                }
//                @Override
//                public boolean onSingleTapConfirmed(MotionEvent event) {
//                    mp = MediaPlayer.create(context, R.raw.ukimwi);
//                    mp.start();
////                    Toast.makeText(getApplicationContext(), "onSingleTap", Toast.LENGTH_SHORT).show();
//                    Log.d("onSingleTapConfirmed", "onSingleTap");
//                    return false;
//                }
//            });
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                gestureDetector.onTouchEvent(event);
//                return true;
//            }
//        });




    }

}
