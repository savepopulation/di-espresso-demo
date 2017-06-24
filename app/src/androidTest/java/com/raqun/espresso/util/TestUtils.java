package com.raqun.espresso.util;

import android.support.annotation.NonNull;

import com.raqun.espresso.vo.User;

/**
 * Created by tyln on 24/06/2017.
 */

public final class TestUtils {

    private TestUtils() {
        // No instance
    }

    @NonNull
    public static User createTestUser() {
        return new User("0", "Test User");
    }
}
