package giltwizy.hopedevelopers.com.eafya.afyaspot;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import giltwizy.hopedevelopers.com.eafya.R;

public class KablaYaUjauzito extends AppCompatActivity {
    MediaPlayer mp;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabla_ya_ujauzito);

        TextView mamboYaKuzingatiaKablaYaUjauzito = findViewById(R.id.mamboYaKuzingatiaKablaYaUjauzito);
        TextView maandaliziKablaYaUjauzito = findViewById(R.id.maandaliziKablaYaUjauzito);
        TextView uzaziWaMpango = findViewById(R.id.uzaziWaMpango);
        TextView njiaZaUzaziWaMpango = findViewById(R.id.njiaZaUzaziWaMpango);
        TextView njiaBoraYaUzaziWaMpango = findViewById(R.id.njiaBoraYaUzaziWaMpango);


        mamboYaKuzingatiaKablaYaUjauzito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(context, R.raw.maelezo_mambo_ya_kuzingatia_kabla_ya_ujauzito);
                mp.start();
            }
        });

        maandaliziKablaYaUjauzito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(context, R.raw.maandalizi_ya_mwili_kabla_ya_ujauzito);
                mp.start();
            }
        });

        uzaziWaMpango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(context, R.raw.uzazi_wa_mpango);
                mp.start();
            }
        });

        njiaZaUzaziWaMpango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(context, R.raw.njia_za_uzazi_wa_mpango);
                mp.start();
            }
        });

        njiaBoraYaUzaziWaMpango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(context, R.raw.njia_ya_kupanga_uzazi_bora);
                mp.start();
            }
        });


    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(1);
    }
}
