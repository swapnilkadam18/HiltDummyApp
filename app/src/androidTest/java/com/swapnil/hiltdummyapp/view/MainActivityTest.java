package com.swapnil.hiltdummyapp.view;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.swapnil.hiltdummyapp.R;

import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Before
    public void setUp() throws Exception {
        ActivityScenario.launch(MainActivity.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void validateCreds() {
        Assert.assertNotNull(onView(withId(R.id.etUserName)));
        Assert.assertNotNull(onView(withId(R.id.etPassword)));
        onView(withId(R.id.etUserName)).check(matches(ViewMatchers.withText("xyz")));
        onView(withId(R.id.etPassword)).check(matches(ViewMatchers.withText("xyz")));
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(ViewMatchers.withText("Login Success")));
        onView(withId(R.id.etPassword)).perform(typeText("abc"));
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(ViewMatchers.withText("Login Failure")));
    }
}