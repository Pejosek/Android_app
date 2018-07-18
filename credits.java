package com.example.adm.projekt4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class credits extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_credits);
    }

}
