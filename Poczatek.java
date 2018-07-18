package com.example.adm.projekt4;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

public class Poczatek extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_poczatek);

        final MediaPlayer sound = MediaPlayer.create(this, R.raw.sound);

        sound.setLooping(true);
        sound.start();

        ImageButton credits = (ImageButton)findViewById(R.id.credits);
        ImageButton new_game = (ImageButton)findViewById(R.id.new_game);
        ImageButton sound_butt = (ImageButton)findViewById(R.id.sound_butt);


        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Poczatek.this, credits.class);
                startActivity(intent1);
            }
        });

        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Poczatek.this, options.class);
                startActivity(intent2);
            }
        });

        sound_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sound.isPlaying()){
                    sound.setLooping(true);
                    sound.start();
                    Toast.makeText(Poczatek.this, "Music ON", Toast.LENGTH_SHORT).show();
                } else {
                    sound.pause();
                    Toast.makeText(Poczatek.this, "Music OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
