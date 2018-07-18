package com.example.adm.projekt4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class options extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_options);


        final EditText editText = (EditText) findViewById(R.id.editText);
        Button start = (Button) findViewById(R.id.button);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editText.getText().toString();

                Intent intent = new Intent(options.this, new_game.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
