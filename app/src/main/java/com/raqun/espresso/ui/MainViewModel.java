package com.raqun.espresso.ui;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;

import com.raqun.espresso.vo.User;

import javax.inject.Inject;

/**
 * Created by tyln on 23/06/2017.
 */

public class MainViewModel extends ViewModel {
    private static final String TAG = "ActualViewModel";

    private final MediatorLiveData<User> userLiveData;

    private final MutableLiveData<String> userIdLiveData;

    @Inject
    MainViewModel() {
        userLiveData = new MediatorLiveData<>();
        userIdLiveData = new MutableLiveData<>();

        userLiveData.addSource(userIdLiveData, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                getUserDetails(s);
            }
        });
    }

    public MediatorLiveData<User> getUser() {
        return userLiveData;
    }

    private void getUserDetails(String userId) {
        /**
         * Simulates network call
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userLiveData.postValue(new User("1", "Actual User"));
            }
        }, 5000);
    }

    public String getTag() {
        return TAG;
    }

    public void setUserId(String userId) {
        userIdLiveData.setValue(userId);
    }
}
