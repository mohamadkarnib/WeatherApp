package com.aniketjain.weatherapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleUnitTest {

    // Simple addition test
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    // Test for temperature conversion
    @Test
    public void testTemperatureConversion() {
        double celsius = 25.0;
        double fahrenheit = (celsius * 9/5) + 32;
        assertEquals(77.0, fahrenheit, 0.01);
    }

    // Test for JSON parsing
    @Test
    public void testJsonParsing() {
        String json = "{ \"temperature\": 25.0 }";  // Example JSON
        WeatherData weatherData = WeatherParser.parse(json); // Assuming WeatherParser is a class for parsing
        assertNotNull(weatherData);
        assertEquals(25.0, weatherData.getTemperature(), 0.01);
    }

    // Test for date formatting
    @Test
    public void testDateFormatting() {
        String formattedDate = DateUtils.formatDate(1609459200000L);  // Example timestamp
        assertEquals("2021-01-01", formattedDate);  // Expected date format
    }
}
