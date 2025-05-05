package com.aniketjain.weatherapp;

import com.aniketjain.weatherapp.models.WeatherResponse;
import com.aniketjain.weatherapp.models.ForecastResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather?appid={API_KEY}&units=metric")
    Call<WeatherResponse> getCurrentWeather(
            @Query("q") String cityName,
            @Path("API_KEY") String apiKey
    );