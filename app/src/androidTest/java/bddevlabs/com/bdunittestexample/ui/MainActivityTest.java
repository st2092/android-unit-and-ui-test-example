package bddevlabs.com.bdunittestexample.ui;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.io.InputStream;

import bddevlabs.com.bdunittestexample.R;
import bddevlabs.com.bdunittestexample.data.model.Place;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(
                    MainActivity.class,
                    true,
                    true
            );

    @Test
    public void freshStart() {
        onView(withId(R.id.placeInfoTextView)).check(matches(withText(R.string.default_message)));
        onView(withId(R.id.showDisneylandInfoButton)).check(matches(withText(R.string.show_disneyland_info)));
    }

    @Test
    public void disneylandInfo() {
        InputStream inputStream = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.disneyland);
        Place disneyland = Place.readFromStream(inputStream);
        String disneylandInfo = disneyland.name + "\n" + disneyland.description;
        onView(withId(R.id.showDisneylandInfoButton)).perform(click());
        onView(withId(R.id.placeInfoTextView)).check(matches(withText(disneylandInfo)));
    }
}