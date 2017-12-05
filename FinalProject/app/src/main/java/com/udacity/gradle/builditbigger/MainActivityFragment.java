package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.m68476521.mike.myandroidlibrary.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public boolean testingFlag = false;
    public String joke = null;

    public Button ButtonCallEnd;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        ButtonCallEnd = root.findViewById(R.id.button_call_end);
        ButtonCallEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMyJoke();
            }
        });
        return root;
    }

    public void callMyJoke(){
        new EndpointsAsyncTask().execute(this);
    }

    public void launchDisplayJokeActivity(){
        if (!testingFlag) {
            Context context = getActivity();
            Intent intent = JokeActivity.newIntent(context,joke);
            context.startActivity(intent);
        }
    }
}
