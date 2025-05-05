package com.aniketjain.weatherapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.aniketjain.weatherapp.models.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private ApiInterface apiInterface;
    private WeatherResponse lastResponse;

    private void showWeather(WeatherResponse response) {
        lastResponse = response; // Cache
        runOnUiThread(() -> {
            ((TextView)findViewById(R.id.temp)).setText(response.getMain().getTemp() + "°C");
        });
    }

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
        apiInterface.getCurrentWeather(city, BuildConfig.WEATHER_API_KEY, "metric")
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        if (response.isSuccessful()) {
                            showWeather(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        // Handle failure (e.g., show an error message)
                    }
                });
    }
}
