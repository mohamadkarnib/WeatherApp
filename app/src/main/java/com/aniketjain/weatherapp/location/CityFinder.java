package com.aniketjain.weatherapp.location;  // add this line

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CityFinder {

    // Set the latitude and longitude in LocationCord
    public static void setLongitudeLatitude(Location location) {
        if (location != null) {
            LocationCoord.lat = String.valueOf(location.getLatitude());
            LocationCoord.lon = String.valueOf(location.getLongitude());
            Log.d("location_lat", LocationCoord.lat);
            Log.d("location_lon", LocationCoord.lon);
        } else {
            Log.d("location", "Location is null");
        }
    }

    // Get the city name from latitude and longitude using Geocoder
    public static String getCityNameUsingNetwork(Context context, Location location) {
        String city = "";
        if (location == null) {
            Log.e("city", "Location is null.");
            return city;
        }

        try {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

            if (addresses != null && !addresses.isEmpty()) {
                city = addresses.get(0).getLocality();
                if (city != null) {
                    Log.d("city", "City found: " + city);
                } else {
                    Log.e("city", "City is null.");
                }
            } else {
                Log.e("city", "No address found for the location.");
            }
        } catch (IOException e) {
            Log.e("city", "Geocoder service not available.", e);
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Log.e("city", "Invalid latitude or longitude values.", e);
            e.printStackTrace();
        }

        return city;
    }
}
