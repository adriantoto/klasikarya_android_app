package com.example.klasikarya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginSplashScreen extends AppCompatActivity {

    private int SLEEP_TIMER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_splash_screen);

        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();

    }


    private class LogoLauncher extends Thread{
        public void run(){
            try{
                sleep(1000 * SLEEP_TIMER);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            Intent intent = new Intent(LoginSplashScreen.this, SecondActivity.class);
            startActivity(intent);
            LoginSplashScreen.this.finish();

        }
    }

}
