package giltwizy.hopedevelopers.com.eafya;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Hiv extends AppCompatActivity {
    MediaPlayer mp;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiv);

        Button rudiNyuma = findViewById(R.id.rudiNyuma);

        TextView ukimwiNiNini = findViewById(R.id.ukimwiNiNini);

        ukimwiNiNini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(context, R.raw.ukimwi_ni_nini);
                mp.start();
            }
        });

        rudiNyuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                mp = MediaPlayer.create(context, R.raw.sitisha);
                mp.start();
            }
        });


    }
}
