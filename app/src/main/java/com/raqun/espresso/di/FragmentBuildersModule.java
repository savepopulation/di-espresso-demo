package com.raqun.espresso.di;

import com.raqun.espresso.ui.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by tyln on 23/06/2017.
 */
@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragment();
}
