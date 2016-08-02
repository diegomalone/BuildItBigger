package com.udacity.gradle.builditbigger.jokedisplay;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeActivityFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_joke, container, false);

        String joke = getActivity().getIntent().getStringExtra(JokeActivity.JOKE_KEY);
        TextView jokeTextView = (TextView) root.findViewById(R.id.textview);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }

        return root;
    }
}
