package com.example.pupil.myfirstproject.ui.fragments;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.CountDownTimer;

public class GreenViewModel extends ViewModel {
    MutableLiveData<Boolean> isActive = new MutableLiveData<>();

    void setIsActive(final Boolean isAct){
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                isActive.postValue(isAct);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
