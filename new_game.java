package com.example.adm.projekt4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class new_game extends Activity {

    MediaPlayer sound2;

    public long time;//licznik czasu
    Bundle bundle;//pakiecik
    String get_name;//zmienna na imie z popzedniego activity
    int punkty = 0;

    CountDownTimer timer2;//odlicza czas

    private ViewGroup mainLayout;
    private ImageView ame_pd;
    private ImageView ame_pn;
    private ImageView afryka;
    private ImageView euroazja;
    private ImageView australia;
    private Button skip;
    private ProgressBar prg;

    private TextView pkt;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView timer;
    private TextView progress;//textView, bedzie pokazywal w jakim % jestesmy levelu
    private TextView name;//imie

    private int xDelta;
    private int yDelta;

    public int executed1 = 0;//liczniki, dzieki nim progress bar zwieksza sie tylko raz.
    public int executed2 = 0;
    public int executed3 = 0;
    public int executed4 = 0;
    public int executed5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        mainLayout = (RelativeLayout) findViewById(R.id.main);

        bundle = getIntent().getExtras();//pakiecik, ktory zawiera dana z poprzedniego activity
        get_name = bundle.getString("name");//Stad biore imie i wrzucam do bundla

        name = (TextView) findViewById(R.id.name2);
        name.setText("Gracz: "+get_name);//ustawiam textView na to co jest w data1

        //pkt.setText("Punkty: "+String.valueOf(punkty));

        sound2 = MediaPlayer.create(this, R.raw.correct);


        ame_pd = (ImageView) findViewById(R.id.ame_pd);//puzzel ame_pd
        ame_pn = (ImageView) findViewById(R.id.ame_pn);
        afryka = (ImageView) findViewById(R.id.afryka);
        euroazja = (ImageView) findViewById(R.id.euroazja);
        australia = (ImageView) findViewById(R.id.australia);

        skip = (Button) findViewById(R.id.skip);//przycisk aby przejsc do level1_done

        pkt = (TextView) findViewById(R.id.punkty2);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        timer = (TextView) findViewById(R.id.timer);
        progress = (TextView) findViewById(R.id.progress);

        prg = (ProgressBar) findViewById(R.id.prg);

        ame_pn.setOnTouchListener(onTouchListener());
        ame_pd.setOnTouchListener(onTouchListener2());
        afryka.setOnTouchListener(onTouchListener3());
        euroazja.setOnTouchListener(onTouchListener4());
        australia.setOnTouchListener(onTouchListener5());

        progress.setText(String.valueOf(prg.getProgress())+"% / 100%");


        timer2 = new CountDownTimer(60000, 1000) {//Tutaj tworze licznik max 60s

            public void onTick(long millisUntilFinished) {
                timer.setText("Pozostały czas: "+String.valueOf(millisUntilFinished/1000));
                time = millisUntilFinished/1000;
            }

            public void onFinish() {
                Toast.makeText(new_game.this, "Czas upłynął. Spróbuj ponownie", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(new_game.this, options.class);
                startActivity(intent);
            }


        }.start();

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(prg.getProgress()==100) {
                    Intent intent = new Intent(new_game.this, level1_done.class);
                    intent.putExtra("punkty", punkty);
                    intent.putExtra("name", get_name);
                    intent.putExtra("time",time);
                    startActivity(intent);
                }
            }
        });
    }

    private OnTouchListener onTouchListener() {
        return new OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                final int x = (int) event.getRawX();//absolutne wspolrzedne w stosunku do ekranu urzadzenia
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN://Rozpoczecie akcji przenoszenia
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;


                        break;


                    case  MotionEvent.ACTION_UP://Zakonczenie akcji przenoszenia
                        RelativeLayout.LayoutParams lParams3 = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        if(lParams3.leftMargin >370){
                            if (lParams3.leftMargin < 510){
                                if(lParams3.topMargin > 120){
                                    if(lParams3.topMargin < 250){
                                        lParams3.leftMargin = 420;
                                        lParams3.topMargin  = 193;
                                        lParams3.width = 500;
                                        lParams3.height = 465;
                                        Toast.makeText(new_game.this, "Dobra robota +20pkt", Toast.LENGTH_SHORT).show();
                                        while(executed1<1){//wykonanie tylko raz ponizszych instrukcji
                                            sound2.start();//correct sound rozpoczecie
                                            prg.incrementProgressBy(20);//zwiekszenie progressbara o 20
                                            punkty=punkty+20;//punkciki
                                            pkt.setText(String.valueOf("Punkty: "+punkty));
                                            progress.setText(String.valueOf(prg.getProgress())+"% / 100%");

                                            if(prg.getProgress()==100){//Przejscie do kolejnego activity
                                                timer2.cancel();
                                                Intent intent1 = new Intent(new_game.this, level1_done.class);
                                                intent1.putExtra("gold", punkty);
                                                intent1.putExtra("name", get_name);
                                                intent1.putExtra("time", time);
                                                startActivity(intent1);
                                            }
                                            executed1++;
                                        }
                                    }
                                }
                            }
                        }

                        break;



                    case MotionEvent.ACTION_MOVE://Ruch objektu
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;

                        //text1.setText(String.valueOf(punkty));
                        //text2.setText(String.valueOf(layoutParams.leftMargin));
                        //text3.setText(String.valueOf(layoutParams.width));
                        view.setLayoutParams(layoutParams);
                        break;
                }
                mainLayout.invalidate();
                return true;
            }
        };
    }

    private OnTouchListener onTouchListener2() {
        return new OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {


                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();



                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;

                        break;

                    case  MotionEvent.ACTION_UP:
                        RelativeLayout.LayoutParams lParams3 = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        if(lParams3.leftMargin >640){
                            if (lParams3.leftMargin < 775){
                                if(lParams3.topMargin > 540){
                                    if(lParams3.topMargin < 700){
                                        lParams3.leftMargin = 680;
                                        lParams3.topMargin  = 577;
                                        //lParams3.width = 500;
                                        //lParams3.height = 465;
                                        Toast.makeText(new_game.this, "Dobra robota +20pkt", Toast.LENGTH_SHORT).show();
                                        while(executed2<1){
                                            sound2.start();
                                            prg.incrementProgressBy(20);
                                            punkty=punkty+20;
                                            pkt.setText(String.valueOf("Punkty: "+punkty));
                                            progress.setText(String.valueOf(prg.getProgress())+"% / 100%");
                                            if(prg.getProgress()==100){
                                                timer2.cancel();
                                                Intent intent1 = new Intent(new_game.this, level1_done.class);
                                                intent1.putExtra("punkty", punkty);
                                                intent1.putExtra("name", get_name);
                                                intent1.putExtra("time",time);
                                                startActivity(intent1);
                                            }
                                            executed2++;
                                        }
                                    }
                                }
                            }
                        }

                        break;


                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;

                        //text1.setText(String.valueOf(layoutParams.topMargin));
                        //text2.setText(String.valueOf(layoutParams.leftMargin));
                        //text3.setText(String.valueOf(layoutParams.width));
                        //text4.setText(String.valueOf(layoutParams.height));
                        view.setLayoutParams(layoutParams);


                        break;
                }
                mainLayout.invalidate();
                return true;
            }
        };
    }

    private OnTouchListener onTouchListener3() {
        return new OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;


                        break;


                    case  MotionEvent.ACTION_UP:
                        RelativeLayout.LayoutParams lParams3 = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        if(lParams3.leftMargin >870){
                            if (lParams3.leftMargin < 1000){
                                if(lParams3.topMargin > 410){
                                    if(lParams3.topMargin < 520){
                                        lParams3.leftMargin = 920;
                                        lParams3.topMargin  = 462;
                                        lParams3.width = 470;
                                        lParams3.height = 333;
                                        Toast.makeText(new_game.this, "Dobra robota +20pkt", Toast.LENGTH_SHORT).show();
                                        while(executed3<1){
                                            sound2.start();
                                            prg.incrementProgressBy(20);
                                            punkty=punkty+20;
                                            pkt.setText(String.valueOf("Punkty: "+punkty));
                                            progress.setText(String.valueOf(prg.getProgress())+"% / 100%");
                                            if(prg.getProgress()==100){
                                                timer2.cancel();
                                                Intent intent1 = new Intent(new_game.this, level1_done.class);
                                                intent1.putExtra("punkty", punkty);
                                                intent1.putExtra("name", get_name);
                                                intent1.putExtra("time",time);
                                                startActivity(intent1);
                                            }
                                            executed3++;
                                        }
                                    }
                                }
                            }
                        }

                        break;



                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;

                        //text1.setText(String.valueOf(layoutParams.topMargin));
                        //text2.setText(String.valueOf(layoutParams.leftMargin));
                        //text3.setText(String.valueOf(layoutParams.width));
                        //text4.setText(String.valueOf(layoutParams.height));
                        view.setLayoutParams(layoutParams);
                        break;
                }
                mainLayout.invalidate();
                return true;
            }
        };
    }

    private OnTouchListener onTouchListener4() {
        return new OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;

                        //lParams.width = 480;
                        //lParams.height = 480;


                        break;


                    case  MotionEvent.ACTION_UP:
                        RelativeLayout.LayoutParams lParams4 = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        if(lParams4.leftMargin >970){
                           if (lParams4.leftMargin < 1430){
                                if(lParams4.topMargin > 30){
                                    if(lParams4.topMargin < 300){
                                        lParams4.leftMargin = 1005;
                                        lParams4.topMargin  = 0;
                                        lParams4.width = 880;
                                        lParams4.height = 800;
                                        Toast.makeText(new_game.this, "Dobra robota +20pkt", Toast.LENGTH_SHORT).show();
                                        while(executed4<1){
                                            sound2.start();
                                            prg.incrementProgressBy(20);
                                            punkty=punkty+20;
                                            pkt.setText(String.valueOf("Punkty: "+punkty));
                                            progress.setText(String.valueOf(prg.getProgress())+"% / 100%");
                                            if(prg.getProgress()==100){
                                                timer2.cancel();
                                                Intent intent1 = new Intent(new_game.this, level1_done.class);
                                                intent1.putExtra("punkty", punkty);
                                                intent1.putExtra("name", get_name);
                                                intent1.putExtra("time",time);
                                                startActivity(intent1);
                                            }
                                            executed4++;
                                        }
                                    }
                                }
                            }
                        }

                        break;



                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;

                        //layoutParams.width = 480;
                        //layoutParams.height = 480;

                        //text1.setText(String.valueOf(layoutParams.topMargin));
                        //text2.setText(String.valueOf(layoutParams.leftMargin));
                        //text3.setText(String.valueOf(layoutParams.width));
                        //text4.setText(String.valueOf(layoutParams.height));
                        view.setLayoutParams(layoutParams);
                        break;
                }
                mainLayout.invalidate();
                return true;
            }
        };
    }

    private OnTouchListener onTouchListener5() {
        return new OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;


                        break;


                    case  MotionEvent.ACTION_UP:
                        RelativeLayout.LayoutParams lParams4 = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        if(lParams4.leftMargin >1475){
                            if (lParams4.leftMargin < 1575){
                                if(lParams4.topMargin > 575){
                                    if(lParams4.topMargin < 675){
                                        lParams4.leftMargin = 1537;
                                        lParams4.topMargin  = 623;
                                        //lParams4.width = 210;
                                        //.height = 210;
                                        Toast.makeText(new_game.this, "Dobra robota +20pkt", Toast.LENGTH_SHORT).show();
                                        while(executed5<1){
                                            sound2.start();
                                            prg.incrementProgressBy(20);
                                            punkty=punkty+20;
                                            pkt.setText(String.valueOf("Punkty: "+punkty));
                                            progress.setText(String.valueOf(prg.getProgress())+"% / 100%");
                                            if(prg.getProgress()==100){
                                                timer2.cancel();
                                                Intent intent1 = new Intent(new_game.this, level1_done.class);
                                                intent1.putExtra("punkty", punkty);
                                                intent1.putExtra("name", get_name);
                                                intent1.putExtra("time",time);
                                                startActivity(intent1);
                                            }
                                            executed5++;
                                        }
                                    }
                                }
                            }
                        }

                        break;



                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;

                        //text1.setText(String.valueOf(layoutParams.topMargin));
                        //text2.setText(String.valueOf(layoutParams.leftMargin));
                        //text3.setText(String.valueOf(layoutParams.width));
                        //text4.setText(String.valueOf(layoutParams.height));
                        view.setLayoutParams(layoutParams);
                        break;
                }
                mainLayout.invalidate();
                return true;
            }
        };
    }

}
