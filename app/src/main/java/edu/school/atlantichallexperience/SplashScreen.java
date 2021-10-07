package edu.school.atlantichallexperience;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by FEMI on 19/01/2018.
 */

public class SplashScreen extends Activity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }

}
