package giltwizy.hopedevelopers.com.eafya.afyaspot;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import giltwizy.hopedevelopers.com.eafya.R;
import giltwizy.hopedevelopers.com.eafya.adapter.AdapterMainActivity;
import giltwizy.hopedevelopers.com.eafya.dataModel.DataModelMainActivity;

import java.util.ArrayList;

public class KablaYaUjauzito extends AppCompatActivity {

    int[] imageArray = {
            R.drawable.ic_baseline_play_arrow_24,
            R.drawable.ic_baseline_play_arrow_24,
            R.drawable.ic_baseline_play_arrow_24,
            R.drawable.ic_baseline_play_arrow_24,
            R.drawable.ic_baseline_play_arrow_24

    };

    String[] nameArray = {
            "Je,ni mambo yapi ya kuzingatia kabla ya ujauzito",
            "Maandalizi sahihi ya mwili kabla ya ujauzito",
            "Fahamu kuhusu uzazi wa mpango",
            "Je,ni zipi njia za uzazi wa mpango?",
            "Je, ni njia ipi ya kupanga uzazi bora kuliko zote?"
    };

    String[] statusArray = {
            "Active",
            "Active",
            "Active",
            "Not Active",
            "Active",

    };

    String[] mobileArray = {
            "+91 9595500400",
            "+91 9595500401",
            "+91 9595500402",
            "+91 9595500403",
            "+91 9595500404",

    };

    GridLayoutManager gridLayoutManager;
    RecyclerView recyclerView;

    AdapterMainActivity mAdapter;
    ArrayList<DataModelMainActivity> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabla_ya_ujauzito);

        recyclerView = findViewById(R.id.recyclerView);

        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        data = new ArrayList<DataModelMainActivity>();
        for (int i = 0; i < nameArray.length; i++) {
            data.add(new DataModelMainActivity(imageArray[i], nameArray[i], statusArray[i], mobileArray[i]));
        }

        mAdapter = new AdapterMainActivity(data, KablaYaUjauzito.this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
