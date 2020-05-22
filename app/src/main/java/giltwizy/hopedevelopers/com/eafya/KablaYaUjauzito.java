package giltwizy.hopedevelopers.com.eafya;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KablaYaUjauzito extends AppCompatActivity {
    MediaPlayer mp;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabla_ya_ujauzito);

        Button rudiNyuma = findViewById(R.id.rudiNyuma);

        TextView umriSahihiKupataUjauzito = findViewById(R.id.umriSahihiKupataUjauzito);

//        umriSahihiKupataUjauzito.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mp = MediaPlayer.create(context, R.raw.umri_wa_kupata_ujauzito);
//                mp.start();
//            }
//        });

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
