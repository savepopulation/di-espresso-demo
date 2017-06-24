package com.raqun.espresso.di;

import android.app.Application;

import com.raqun.espresso.EspressoApplication;
import com.raqun.espresso.ui.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjectionModule;

/**
 * Created by tyln on 23/06/2017.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class,
        MainActivityModule.class,
        AppModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(EspressoApplication application);
}
