package com.example.sample;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.app.Activity;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.sample.view.Display;
import com.example.sample.view.MainActivity;
import com.example.sample.viewmodel.SampleViewModel;

import org.junit.Rule;
import org.junit.Test;

public class DisplayTest {
@Rule
    public ActivityScenarioRule<Display> get=new ActivityScenarioRule<Display>(Display.class);
    private String val="cat";

    @Test
public void change(){
    ActivityScenario scenario=get.getScenario();
    Display display=new Display();
    onView(withId(R.id.view)).perform(click());
    onView(withId(R.id.view)).check(matches(isDisplayed()));



}

}
