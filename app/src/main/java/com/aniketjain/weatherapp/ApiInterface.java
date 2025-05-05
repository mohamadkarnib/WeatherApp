package com.example.weatherapp;  // Update with your actual package name

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather?appid={API_KEY}&units=metric")
    Call<WeatherResponse> getWeatherData(@Query("q") String cityName);

    @GET("forecast?appid={API_KEY}&units=metric")
    Call<ForecastResponse> getForecastData(@Query("q") String cityName);
    // In ApiInterface.java (for testing only)
    @GET("weather")
    Call<WeatherResponse> getMockWeather() {
        "main": {"temp": 22.5},
        "weather": [{"description": "Sunny"}]
    }
}