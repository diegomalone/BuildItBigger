package com.udacity.gradle.builditbigger.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokeActivity extends AppCompatActivity {

    public static String JOKE_KEY = "Jokekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }
}
