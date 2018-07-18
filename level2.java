package com.example.adm.projekt4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class level2 extends Activity {

    /*MediaPlayer sound2;
    private ProgressBar prg;
    CountDownTimer timer3;
    long time;

    int punkty2 = 0;

    private TextView timer;

    private TextView progress;
    private TextView punkt;
    private TextView nick;

    EditText ame_pn;
    EditText ame_pd;
    EditText afryka;
    EditText euroazja;
    EditText australia;

    public int executed1 = 0;//licznik
    public int executed2 = 0;
    public int executed3 = 0;
    public int executed4 = 0;
    public int executed5 = 0;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_level2);


        /*prg = (ProgressBar) findViewById(R.id.prg);
        sound2 = MediaPlayer.create(this, R.raw.correct);

        Bundle bundle = getIntent().getExtras();

        final String nick2 = bundle.getString("name");
        final long pkt = bundle.getLong("punkty");


        timer = (TextView) findViewById(R.id.timer);
        punkt = (TextView) findViewById(R.id.punkty2);
        progress = (TextView) findViewById(R.id.progress);
        nick = (TextView) findViewById(R.id.name2);

        ame_pn =  (EditText) findViewById(R.id.ame_pn);
        ame_pd =  (EditText) findViewById(R.id.ame_pd);
        afryka =  (EditText) findViewById(R.id.afryka);
        euroazja =  (EditText) findViewById(R.id.euroazja);
        australia =  (EditText) findViewById(R.id.australia);

        //nick.setText("Gracz: "+name);*/

        /*timer3 = new CountDownTimer(200000, 1000) {//Tutaj tworze licznik max 60s

            public void onTick(long millisUntilFinished) {
                timer.setText("Pozostały czas: "+String.valueOf(millisUntilFinished/1000));
                time = millisUntilFinished/1000;
                progress.setText(String.valueOf(prg.getProgress())+"% / 100%");
                punkt.setText("Punkty: "+String.valueOf(punkty2));

                if(ame_pn.getText().toString().equals("ameryka polnocna")) {
                    while (executed1 < 1) {
                        sound2.start();
                        prg.incrementProgressBy(20);
                        Toast.makeText(level2.this, "Dobra robota +30pkt", Toast.LENGTH_SHORT).show();
                        punkty2 = punkty2 +30;
                        if(prg.getProgress()==100){//Przejscie do kolejnego activity
                            timer3.cancel();
                            Intent intent1 = new Intent(level2.this, level2_done.class);
                            intent1.putExtra("punkty2", punkty2);
                            intent1.putExtra("name", nick2);
                            intent1.putExtra("time", time);
                            //intent1.putExtra("pkt", pkt);
                            startActivity(intent1);
                        }
                        executed1++;
                    }
                }
                if(ame_pd.getText().toString().equals("ameryka poludniowa")) {
                    while (executed2 < 1) {
                        Toast.makeText(level2.this, "Dobra robota +30pkt", Toast.LENGTH_SHORT).show();
                        sound2.start();
                        prg.incrementProgressBy(20);
                        punkty2 = punkty2 +30;
                        if(prg.getProgress()==100){//Przejscie do kolejnego activity
                            timer3.cancel();
                            Intent intent1 = new Intent(level2.this, level2_done.class);
                            //intent1.putExtra("punkty", punkty2);
                            //intent1.putExtra("name", name);
                            //intent1.putExtra("time", time);
                            //intent1.putExtra("pkt", pkt);
                            startActivity(intent1);
                        }
                        executed2++;
                    }
                }

                if(euroazja.getText().toString().equals("euroazja")) {
                    while (executed3 < 1) {
                        Toast.makeText(level2.this, "Dobra robota +30pkt", Toast.LENGTH_SHORT).show();
                        sound2.start();
                        prg.incrementProgressBy(20);
                        punkty2 = punkty2 +30;
                        if(prg.getProgress()==100){//Przejscie do kolejnego activity
                            timer3.cancel();
                            Intent intent1 = new Intent(level2.this, level2_done.class);
                            //intent1.putExtra("punkty", punkty2);
                            //intent1.putExtra("name", name);
                            //intent1.putExtra("time", time);
                            //intent1.putExtra("pkt", pkt);
                            startActivity(intent1);
                        }
                        executed3++;
                    }
                }

                if(afryka.getText().toString().equals("afryka")) {
                    while (executed4 < 1) {
                        Toast.makeText(level2.this, "Dobra robota +30pkt", Toast.LENGTH_SHORT).show();
                        sound2.start();
                        prg.incrementProgressBy(20);
                        punkty2 = punkty2 +30;
                        if(prg.getProgress()==100){//Przejscie do kolejnego activity
                            timer3.cancel();
                            Intent intent1 = new Intent(level2.this, level2_done.class);
                            //intent1.putExtra("punkty", punkty2);
                            //intent1.putExtra("name", name);
                            //intent1.putExtra("time", time);
                            //intent1.putExtra("pkt", pkt);
                            startActivity(intent1);
                        }
                        executed4++;
                    }
                }

                if(australia.getText().toString().equals("australia")) {
                    while (executed5 < 1) {
                        Toast.makeText(level2.this, "Dobra robota +30pkt", Toast.LENGTH_SHORT).show();
                        sound2.start();
                        prg.incrementProgressBy(20);
                        punkty2 = punkty2 +30;
                        if(prg.getProgress()==100){//Przejscie do kolejnego activity
                            timer3.cancel();
                            Intent intent1 = new Intent(level2.this, level2_done.class);
                            //intent1.putExtra("punkty", punkty2);
                            //intent1.putExtra("name", name);
                            //intent1.putExtra("time", time);
                            //intent1.putExtra("pkt", pkt);
                            startActivity(intent1);
                        }
                        executed5++;
                    }
                }
            }



            public void onFinish() {
                Toast.makeText(level2.this, "Czas upłynął. Spróbuj ponownie", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(level2.this, level1_done.class);
                startActivity(intent);
            }


        }.start();*/
    }
}
