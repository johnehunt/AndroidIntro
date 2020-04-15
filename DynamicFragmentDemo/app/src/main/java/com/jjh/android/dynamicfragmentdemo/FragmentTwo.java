package com.jjh.android.dynamicfragmentdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    private static final String TAG = "FragmentTwo";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG , "onCreateView()");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmenttwo, container, false);
        return view;
    }

}
