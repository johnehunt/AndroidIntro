package com.jjh.fragmentdemo;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Date;

public class DateTimeFragment extends Fragment {
    private String time;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        if (time == null) {
            time = new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(new Date());
        }
        Log.d("DateTimeFragment", "onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView view = new TextView(this.getActivity());
        view.setText(time);
        Log.d("DateTimeFragment", "onCreateView()");
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("DateTimeFragment", "onAttach()");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("DateTimeFragment", "onViewCreated()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("DateTimeFragment", "onActivityCreated()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("DateTimeFragment", "onDestroyView()");
    }
}
