package com.jjh.countertestapp;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void increment_button_click() {

        // Simulate user clicking on add button
        onView(withId(R.id.add))            // withId(R.id.my_view) is a ViewMatcher
                .perform(click());               // click() is a ViewAction

        // Check that the text was changed.
        onView(withId(R.id.textView))
                .check(matches(withText("1")));
    }

}
