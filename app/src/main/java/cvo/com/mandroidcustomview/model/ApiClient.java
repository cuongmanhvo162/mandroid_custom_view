package cvo.com.mandroidcustomview.model;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import cvo.com.mandroidcustomview.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static String mApiBaseUrl = BuildConfig.HOST;

    private static ApiClient mApiClient;
    private static ApiRequest mApiRequest;

    // Default constructor for singleton pattern
    private ApiClient() { }

    private void create() {
        HttpLoggingInterceptor logging = createHttpLoggingInterceptor();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(mApiBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiRequest = retrofit.create(ApiRequest.class);
    }

    @NonNull
    private HttpLoggingInterceptor createHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    public static ApiClient getInstance() {
        if (mApiClient == null) {
            mApiClient = new ApiClient();
            mApiClient.create();

            return mApiClient;
        }

        return mApiClient;
    }

    public ApiRequest getApiRequest() {
        return mApiRequest;
    }
}
