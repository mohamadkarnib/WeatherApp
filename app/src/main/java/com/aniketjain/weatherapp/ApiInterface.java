package com.aniketjain.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather?appid=" + BuildConfig.WEATHER_API_KEY + "&units=metric")
    Call<WeatherResponse> getWeatherData(@Query("q") String cityName);

    @GET("forecast?appid=" + BuildConfig.WEATHER_API_KEY + "&units=metric")
    Call<ForecastResponse> getForecastData(@Query("q") String cityName);
}