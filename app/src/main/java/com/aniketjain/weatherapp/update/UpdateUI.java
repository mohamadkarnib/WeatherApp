package com.aniketjain.weatherapp.update;

import android.content.Context;
import com.aniketjain.weatherapp.R;

public class UpdateUI {

    public static String getIconID(int condition, long updateTime, long sunrise, long sunset) {
        if (condition >= 200 && condition <= 232) {
            return "thunderstorm";
        } else if (condition >= 300 && condition <= 321) {
            return "drizzle";
        } else if (condition >= 500 && condition <= 531) {
            return "rain";
        } else if (condition >= 600 && condition <= 622) {
            return "snow";
        } else if (condition >= 701 && condition <= 781) {
            return "wind";
        } else if (condition == 800) {
            return (updateTime >= sunrise && updateTime <= sunset) ? "clear_day" : "clear_night";
        } else if (condition == 801) {
            return (updateTime >= sunrise && updateTime <= sunset) ? "few_clouds_day" : "few_clouds_night";
        } else if (condition == 802) {
            return "scattered_clouds";
        } else if (condition == 803 || condition == 804) {
            return "broken_clouds";
        }
        return "unknown";
    }

    public static String TranslateDay(String day, Context context) {
        switch (day.trim()) {
            case "Monday":
                return context.getString(R.string.monday);
            case "Tuesday":
                return context.getString(R.string.tuesday);
            case "Wednesday":
                return context.getString(R.string.wednesday);
            case "Thursday":
                return context.getString(R.string.thursday);
            case "Friday":
                return context.getString(R.string.friday);
            case "Saturday":
                return context.getString(R.string.saturday);
            case "Sunday":
                return context.getString(R.string.sunday);
            default:
                return day;
        }
    }
}
