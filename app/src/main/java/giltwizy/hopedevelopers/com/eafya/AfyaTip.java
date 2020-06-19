package giltwizy.hopedevelopers.com.eafya;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class AfyaTip extends AppCompatActivity {

    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afya_tip);
    }

    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2) {
//                    go to the left activity
                    Intent i = new Intent(AfyaTip.this, MainActivity.class);
                    startActivity(i);
                } else if (x1 > x2) {
//                    go to the right activity
                    Intent i = new Intent(AfyaTip.this, Icast.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}