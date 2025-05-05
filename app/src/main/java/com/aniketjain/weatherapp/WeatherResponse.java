package com.aniketjain.weatherapp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {
    @SerializedName("main")
    public Main main;

    @SerializedName("weather")
    public List<Weather> weather;

    @SerializedName("name")
    public String cityName;

    public class Main {
        @SerializedName("temp")
        public double temperature;

        @SerializedName("humidity")
        public int humidity;

        @SerializedName("temp_min")
        public double tempMin;

        @SerializedName("temp_max")
        public double tempMax;
    }

    public class Weather {
        @SerializedName("description")
        public String description;

        @SerializedName("icon")
        public String icon;
    }
}