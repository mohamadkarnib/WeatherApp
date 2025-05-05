package com.aniketjain.weatherapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
// Delete the nested interface from MainActivity and import the new one:


import com.aniketjain.weatherapp.models.WeatherResponse;

public class HomeActivity extends AppCompatActivity {
    private ApiInterface apiInterface;
    private WeatherResponse lastResponse;

    private void showWeather(WeatherResponse response) {
        lastResponse = response; // Cache
        runOnUiThread(() -> {
            ((TextView)findViewById(R.id.temp)).setText(response.getMain().getTemp() + "°C");
        });


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
        fetchWeather("London"); // Test with default city
    }

    private void fetchWeather(String city) {
        apiInterface.getCurrentWeather(city, BuildConfig.WEATHER_API_KEY)
                .enqueue(new Callback<WeatherResponse>() {
                    // Handle response
                });
    }
}
