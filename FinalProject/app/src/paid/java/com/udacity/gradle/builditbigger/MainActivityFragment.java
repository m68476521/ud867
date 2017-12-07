package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.m68476521.mike.myandroidlibrary.JokeActivity;

public class MainActivityFragment extends Fragment {
    public boolean testingFlag = false;
    public String joke = null;
    ProgressBar progressBar = null;
    public Button ButtonCallEnd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        ButtonCallEnd = root.findViewById(R.id.button_call_end);
        ButtonCallEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                callMyJoke();
            }
        });
        progressBar =  root.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);
        return root;
    }

    public void callMyJoke() {
        new EndpointsAsyncTask().execute(this);
    }

    public void launchDisplayJokeActivity() {
        if (!testingFlag) {
            Context context = getActivity();
            Intent intent = JokeActivity.newIntent(context, joke);
            context.startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }
    }
}

