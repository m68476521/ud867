package com.m68476521.mike.myandroidlibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class JokeActivity extends SingleFragmentActivity {

    private static final String ARG_JOKE = "joke";

    public static Intent newIntent(Context packageContent, String id) {
        Intent intent = new Intent(packageContent, JokeActivity.class);
        Log.d("MIKE1", id);
        intent.putExtra(ARG_JOKE, id);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        String joke = getIntent().getStringExtra(ARG_JOKE);
        Log.d("MIKE2", joke);
        return JokeFragment.newInstance(joke);
    }
}
