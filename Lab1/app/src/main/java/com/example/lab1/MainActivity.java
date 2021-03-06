package com.example.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
    }

    public void start(){
        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3000);
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                    finish();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

}
