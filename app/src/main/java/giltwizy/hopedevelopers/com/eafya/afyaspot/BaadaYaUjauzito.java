package giltwizy.hopedevelopers.com.eafya.afyaspot;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import giltwizy.hopedevelopers.com.eafya.R;

public class BaadaYaUjauzito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baada_ya_ujauzito);
    }

    @Override
    public void onBackPressed() {
        Intent baadaYaUjauzitoTitleActivity = new Intent(BaadaYaUjauzito.this, BaadaYaUjauzitoTitle.class);
        startActivity(baadaYaUjauzitoTitleActivity);
    }
}