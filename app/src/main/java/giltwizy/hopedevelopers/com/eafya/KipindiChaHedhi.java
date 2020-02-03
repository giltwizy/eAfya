package giltwizy.hopedevelopers.com.eafya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class KipindiChaHedhi extends AppCompatActivity {

    MediaPlayer mp;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kipindi_cha_hedhi);


//        CardView hedhiCardView = findViewById(R.id.hedhiCardView);
//
//        hedhiCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mp = MediaPlayer.create(context, R.raw.kipindi_cha_hedhi);
//                Intent openKipindiChaHedhi = new Intent(getApplicationContext(),KipindiChaHedhi.class);
//                startActivity(openKipindiChaHedhi);
//
//            }
//        });
    }
}
