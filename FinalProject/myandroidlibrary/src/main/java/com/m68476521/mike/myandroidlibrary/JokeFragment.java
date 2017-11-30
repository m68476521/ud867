package com.m68476521.mike.myandroidlibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mike on 11/28/17.
 */

public class JokeFragment extends Fragment {
    private static final String ARG_JOKE = "joke";
    private String joke = "";

    public static JokeFragment newInstance(String id) {
        Bundle args = new Bundle();

        args.putString(ARG_JOKE, id);

        JokeFragment jokeFragment = new JokeFragment();
        jokeFragment.setArguments(args);
        return jokeFragment;
    }

    public JokeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        joke = getArguments().getString(ARG_JOKE);
        TextView textJoke = view.findViewById(R.id.libraryTextViewJoke);
        textJoke.setText(joke);
        return view;
    }
}