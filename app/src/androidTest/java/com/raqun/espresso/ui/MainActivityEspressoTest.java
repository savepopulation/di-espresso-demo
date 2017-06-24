package com.raqun.espresso.ui;

import android.arch.lifecycle.MediatorLiveData;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.raqun.espresso.testing.SingleFragmentActivity;
import com.raqun.espresso.util.TestUtils;
import com.raqun.espresso.util.ViewModelUtil;
import com.raqun.espresso.vo.User;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

/**
 * Created by tyln on 23/06/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    private MainFragment mainFragment;
    private MainViewModel mainViewModel;
    final MediatorLiveData<User> userLiveData = new MediatorLiveData<>();

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityTestRule
            = new ActivityTestRule<>(SingleFragmentActivity.class, true, true);

    @Before
    public void init() {
        mainFragment = MainFragment.newInstance();
        mainViewModel = Mockito.mock(MainViewModel.class);

        when(mainViewModel.getUser()).thenReturn(userLiveData);

        mainFragment.viewModelFactory = ViewModelUtil.createFor(mainViewModel);
        activityTestRule.getActivity().setFragment(mainFragment);
    }

    /**
     * Creates a Test User
     * And Tests if we can display it on screen
     */
    @Test
    public void ensureUserNameCanBeDisplayed() {
        final User user = TestUtils.createTestUser();
        userLiveData.postValue(user);
        onView(withText(user.getUserName())).check(matches(isDisplayed()));
    }

}
