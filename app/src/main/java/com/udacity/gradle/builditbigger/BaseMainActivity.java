package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.udacity.gradle.builditbigger.jokedisplay.JokeActivity;


public class BaseMainActivity extends AppCompatActivity {

    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fetchJoke(View view) {
        new JokeAsyncTask().execute(this);
    }

    public void tellJoke(String joke) {
        mJoke = joke;
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(intent);
    }

    public String getJoke() {
        return mJoke;
    }
}
