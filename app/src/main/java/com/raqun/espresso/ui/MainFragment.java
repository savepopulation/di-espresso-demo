package com.raqun.espresso.ui;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raqun.espresso.R;
import com.raqun.espresso.databinding.FragmentMainBinding;
import com.raqun.espresso.testing.SingleFragmentActivity;
import com.raqun.espresso.vo.User;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by tyln on 23/06/2017.
 */

public class MainFragment extends LifecycleFragment implements LifecycleOwner {

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    MainViewModel mainViewModel;

    FragmentMainBinding binding;

    @NonNull
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        if (getActivity() instanceof HasSupportFragmentInjector) {
            AndroidSupportInjection.inject(this);
        }
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, null, false);
        binding = DataBindingUtil.bind(view);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(MainViewModel.class);

        mainViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                binding.setUser(user);
            }
        });

        binding.setViewModelTag(mainViewModel.getTag());
        mainViewModel.setUserId("1");
    }
}
