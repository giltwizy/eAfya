package giltwizy.hopedevelopers.com.eafya.afyaspot;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import giltwizy.hopedevelopers.com.eafya.R;

public class WakatiWaUjauzito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wakati_wa_ujauzito);
    }

    @Override
    public void onBackPressed() {
        Intent wakatiWaUjauzitoTitleActivity = new Intent(WakatiWaUjauzito.this, WakatiWaUjauzitoTitle.class);
        startActivity(wakatiWaUjauzitoTitleActivity);
    }
}