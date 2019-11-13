package giltwizy.hopedevelopers.com.eafya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Age extends AppCompatActivity {
    Context context = this;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        TextView miakakumi = findViewById(R.id.miakakumi);

        final Timer timer = new Timer();
        mp = MediaPlayer.create(context, R.raw.sajili_umri);
        mp.start();

        miakakumi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                mp = MediaPlayer.create(context, R.raw.miaka_kumi_na_kumiananne);
                switch ( arg1.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        try {
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.release();

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
                                Intent mainActivityIntent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(mainActivityIntent);
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


    }
}
