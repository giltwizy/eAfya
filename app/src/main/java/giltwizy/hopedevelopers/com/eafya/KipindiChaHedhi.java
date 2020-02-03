package giltwizy.hopedevelopers.com.eafya;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class KipindiChaHedhi extends AppCompatActivity {

    MediaPlayer mp;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kipindi_cha_hedhi);


        ImageButton hedhiDefinition = findViewById(R.id.hedhidefinition);

        hedhiDefinition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(context, R.raw.hedhi_definition);
                mp.start();
            }
        });
    }
}
