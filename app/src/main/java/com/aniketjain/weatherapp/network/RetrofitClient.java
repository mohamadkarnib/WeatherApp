import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import java.util.concurrent.TimeUnit;
import com.aniketjain.weatherapp.ApiInterface;
import com.aniketjain.weatherapp.BuildConfig;  // Add this import statement


public class RetrofitClient {
    private static final int TIMEOUT = 30;
    private static Retrofit retrofit;

    public static synchronized ApiInterface getApi() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)  // This should now work after you define BASE_URL in build.gradle
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
