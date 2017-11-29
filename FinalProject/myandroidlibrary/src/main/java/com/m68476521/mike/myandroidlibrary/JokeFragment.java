package com.m68476521.mike.myandroidlibrary;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.m68476521.mike.myandroidlibrary.databinding.FragmentJokeBinding;

/**
 * Created by mike on 11/28/17.
 */

public class JokeFragment extends Fragment {
    private static final String ARG_JOKE = "joke";
    private String joke = "";
    private FragmentJokeBinding Binding;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        joke = getArguments().getString(ARG_JOKE);
        Log.d("MIKE3", joke);
        Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_joke, container, false);
        Binding.libraryTextViewJoke.setText(joke);
        return Binding.getRoot();
    }
}