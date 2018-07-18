package com.example.adm.projekt4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class level2_done extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_level2_done);

        /*Bundle bundle = getIntent().getExtras();

        long time = bundle.getLong("time");
        final String name = bundle.getString("name");
        int pkt = bundle.getInt("pkt");
        int punkty2 = bundle.getInt("punkty");

        final long punkciki = pkt + time*10 +punkty2;

        TextView nick = (TextView) findViewById(R.id.name);
        TextView timer = (TextView) findViewById(R.id.time);
        TextView punkty = (TextView) findViewById(R.id.punkty);
        //Button next = (Button) findViewById(R.id.next);

        timer.setText("Twój czas do końca: "+String.valueOf(time));
        nick.setText("Gracz: "+name);
        punkty.setText("Uzyskane punkty: "+punkciki);*/
    }
}
