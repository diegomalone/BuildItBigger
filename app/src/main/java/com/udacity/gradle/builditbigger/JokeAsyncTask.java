package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;

import java.io.IOException;

/**
 * Created by Malone on 10/10/2015.
 */
public class JokeAsyncTask extends AsyncTask<Context, Void, String> {
    private static JokeApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://udacity-gradle-final-project.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.getjoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        ((BaseMainActivity) context).tellJoke(result);
    }
}