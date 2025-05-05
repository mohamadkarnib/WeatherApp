package com.aniketjain.weatherapp.models;
// At the top of both model classes
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastResponse {
    @SerializedName("list")
    public List<ForecastItem> forecastItems;

    public class ForecastItem {
        @SerializedName("dt_txt")
        public String date;

        @SerializedName("main")
        public Main main;

        @SerializedName("weather")
        public List<Weather> weather;

        public class Main {
            @SerializedName("temp")
            public double temperature;
        }

        public class Weather {
            @SerializedName("icon")
            public String icon;
        }
    }
}