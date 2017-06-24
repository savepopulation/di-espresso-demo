package com.raqun.espresso.di;

import android.app.Fragment;

import com.raqun.espresso.testing.SingleFragmentActivity;
import com.raqun.espresso.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by tyln on 23/06/2017.
 */
@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
