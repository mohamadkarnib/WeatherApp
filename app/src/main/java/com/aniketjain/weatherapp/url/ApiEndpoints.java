public class ApiEndpoints {
    public static final String API_VERSION = "2.5";
    public static final String BASE_URL = "https://api.openweathermap.org/data/" + API_VERSION + "/";

    public static String getCurrentWeather() {
        return BASE_URL + "weather";
    }

    public static String getForecast() {
        return BASE_URL + "forecast";
    }
}