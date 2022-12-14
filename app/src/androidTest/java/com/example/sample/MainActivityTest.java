package com.example.sample;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.sample.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    private String val="karthi";
    @Rule
    public ActivityScenarioRule<MainActivity> intentsTestRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

//    @Rule
//    public ActivityScenarioRule<DisplayTe> display=new ActivityScenarioRule<DisplayTest>(DisplayTest.class);



//    @Test
//    @Before
//    public void enterKey(){
//        ActivityScenario scenario=intentsTestRule.getScenario();
//
//    }
    @Test
    public void getBtn(){
        ActivityScenario scenario=intentsTestRule.getScenario();
        onView(withId(R.id.key)).perform(typeText(val));

        onView(withId(R.id.get)).perform(click());
        Intent intent=new Intent(InstrumentationRegistry.getInstrumentation().getTargetContext(), DisplayTest.class);
        intent.putExtra("key",val);
       ActivityScenario.launch(intent);
//        onView(withId(R.id.display)).check(matches(isDisplayed()));

    }
}
