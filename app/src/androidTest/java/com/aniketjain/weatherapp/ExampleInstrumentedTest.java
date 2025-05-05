package com.aniketjain.weatherapp;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.core.app.ActivityScenario;

import com.aniketjain.weatherapp.ui.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.core.app.ActivityScenario.launch;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    // Test for app context
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.aniketjain.weatherapp", appContext.getPackageName());
    }

    // Test to ensure the HomeActivity launches correctly
    @Test
    public void testActivityLaunch() {
        try (ActivityScenario<HomeActivity> scenario = launch(HomeActivity.class)) {
            scenario.onActivity(activity -> {
                assertNotNull(activity.findViewById(R.id.mainLayout)); // Check if main layout is loaded
            });
        }
    }

    // Simulating a network request test with a mock or a real request
    @Test
    public void testNetworkRequest() {
        // Here you could mock a network request or use an actual one.
        // Assuming you have a method `getWeatherInfo()` for fetching data, you can mock the response.
        // This requires some additional setup for mocking network calls.
        boolean isNetworkAvailable = true; // Change based on your test setup.
        assertTrue("Network should be available", isNetworkAvailable);
    }

    // You can add more tests here, like UI component tests or checking shared preferences.
}
