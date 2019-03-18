package com.example.pupil.myfirstproject.ui.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pupil.myfirstproject.R;

public class GreenFragment extends BaseFragment {

    private GreenViewModel mViewModel;
    private Button button;

    public static GreenFragment newInstance() {
        return new GreenFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.green_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = getView().findViewById(R.id.button);
        mViewModel = ViewModelProviders.of(this).get(GreenViewModel.class);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mViewModel.setIsActive(true);
            }
        });
        mViewModel.isActive.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                Toast.makeText(getContext(), "isActive =" + String.valueOf(aBoolean), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override//подписывает кнопку
    public String getName() {
        return "Green";
    }
}
