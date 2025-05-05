package com.aniketjain.weatherapp.url;

import com.aniketjain.weatherapp.location.LocationCoord;

public class URL {
    private String link;
    private static String city_url;

    public URL() {
        // Ensure latitude and longitude are set before constructing the link
        if (LocationCoord.lat.isEmpty() || LocationCoord.lon.isEmpty()) {
            // Log a warning or handle error if location coordinates are empty
            link = ""; // You can choose to throw an exception or return an error message
        } else {
            link = "https://api.openweathermap.org/data/2.5/onecall?exclude=minutely&lat="
                    + LocationCoord.lat + "&lon=" + LocationCoord.lon + "&appid=" + LocationCoord.API_KEY;
        }
    }

    public String getLink() {
        return link;
    }

    public static void setCity_url(String cityName) {
        if (cityName != null && !cityName.isEmpty()) {
            city_url = "https://api.openweathermap.org/data/2.5/weather?&q=" + cityName + "&appid=" + LocationCoord.API_KEY;
        } else {
            // Handle error if cityName is null or empty
            city_url = ""; // Set a default error URL or log a warning
        }
    }

    public static String getCity_url() {
        return city_url;
    }
}
