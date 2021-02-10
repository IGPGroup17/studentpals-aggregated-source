package com.igp17.studentpals_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Hello world");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}