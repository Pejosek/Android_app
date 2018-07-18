package com.example.adm.projekt4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class level1_done extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_level1_done);

        Bundle bundle = getIntent().getExtras();

        long time1 = bundle.getLong("time");
        final String nick = bundle.getString("name");
        int pkt = bundle.getInt("gold");

        final long goldy = pkt + time1*10;

        TextView textView = (TextView) findViewById(R.id.progress);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView zdobyte = (TextView) findViewById(R.id.punkty2);
        Button button = (Button) findViewById(R.id.button);

        textView.setText("Twój czas do końca: "+String.valueOf(time1));
        textView2.setText("Gracz: "+nick);
        zdobyte.setText("Uzyskane punkty: "+goldy);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(level1_done.this, credits.class);
                intent.putExtra("goldy", goldy);
                intent.putExtra("name", nick);
                startActivity(intent);
            }
        });
    }
}
