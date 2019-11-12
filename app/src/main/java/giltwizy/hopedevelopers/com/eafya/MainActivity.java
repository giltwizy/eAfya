package giltwizy.hopedevelopers.com.eafya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    MediaPlayer mp;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView hedhi = findViewById(R.id.hedhiCardView);
        CardView hiv = findViewById(R.id.hivCardView);
        CardView uzazi = findViewById(R.id.uzaziWaMpangoCardView);
//        CardView simu = findViewById(R.id.simuCardView);
//        CardView ujumbe = findViewById(R.id.ujumbeWaManenoCardView);
//        CardView picha = findViewById(R.id.pichaCardView);

         final Timer timer = new Timer();
        mp = MediaPlayer.create(context, R.raw.test);

        hedhi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                switch ( arg1.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        try {
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.release();
                                mp = MediaPlayer.create(context, R.raw.test);
                            } else {
                                mp.start();
                            }
                        } catch(Exception e) { e.printStackTrace(); }
                        //start timer
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                mp.stop();
                                mp.release();
                                Intent hedhiIntent = new Intent(getApplicationContext(),Hedhi.class);
                                startActivity(hedhiIntent);
                            }
                        }, 5000); //time out 5s
                        return true;
                    case MotionEvent.ACTION_UP:
                        //stop timer
                        timer.cancel();
                        return true;
                }
                return false;
            }


        });


//        hiv.setOnTouchListener(new View.OnTouchListener() {
//             Timer timer = new Timer();
//            @Override
//            public boolean onTouch(View arg0, MotionEvent arg1) {
//                switch ( arg1.getAction() ) {
//                    case MotionEvent.ACTION_DOWN:
//                        try {
//                            if (mp.isPlaying()) {
//                                mp.stop();
//                                mp.release();
//                                mp = MediaPlayer.create(context, R.raw.test2);
//                            } else {
//                                mp.start();
//                            }
//                        } catch(Exception e) { e.printStackTrace(); }
//                        //start timer
//                        timer.schedule(new TimerTask() {
//                            @Override
//                            public void run() {
//                                mp.stop();
//                                Intent hedhiIntent = new Intent(getApplicationContext(),Hiv.class);
//                                startActivity(hedhiIntent);
//                            }
//                        }, 5000); //time out 5s
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        //stop timer
//                        timer.cancel();
//                        return true;
//                }
//                return false;
//            }
//        });


//        uzazi.setOnTouchListener(new View.OnTouchListener() {
//            final Timer timer = new Timer();
//            @Override
//            public boolean onTouch(View arg0, MotionEvent arg1) {
//                switch ( arg1.getAction() ) {
//                    case MotionEvent.ACTION_DOWN:
//
//                        try {
//                            if (mp.isPlaying()) {
//                                mp.stop();
//                                mp.release();
//                                mp = MediaPlayer.create(context, R.raw.test);
//                            } else {
//                                mp.start();
//                            }
//                        } catch(Exception e) { e.printStackTrace(); }
//
//                        //start timer
//                        timer.schedule(new TimerTask() {
//                            @Override
//                            public void run() {
//                                mp.stop();
//                                Intent hedhiIntent = new Intent(getApplicationContext(),Uzazi.class);
//                                startActivity(hedhiIntent);
//                            }
//                        }, 5000); //time out 5s
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        //stop timer
//                        timer.cancel();
//                        return true;
//                }
//                return false;
//            }
//        });

    }

}
