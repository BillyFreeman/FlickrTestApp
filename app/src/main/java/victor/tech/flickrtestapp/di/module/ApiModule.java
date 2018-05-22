package victor.tech.flickrtestapp.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import victor.tech.flickrtestapp.BuildConfig;
import victor.tech.flickrtestapp.api.FlickrApi;

@Module
public class ApiModule {

    public static final String TAG_API_KEY = "api_key";
    public static final String TAG_BASE_URL = "base_url";
    public static final String TAG_API_KEY_INTERCEPTOR = "api_key_interceptor";
    public static final String TAG_LOGGER_INTERCEPTOR = "logger_interceptor";
    public static final String TAG_REST_JSON_INTERCEPTOR = "rest_json_interceptor";

    @Provides
    @Singleton
    @Named(TAG_BASE_URL)
    public String provideBaseUrl() {
        return BuildConfig.BASE_URL;
    }

    @Provides
    @Singleton
    @Named(TAG_API_KEY)
    public String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    @Named(TAG_API_KEY_INTERCEPTOR)
    public Interceptor provideApiKeyInterceptor(@Named(TAG_API_KEY) final String apiKey) {
        return chain -> {
            Request request = chain.request();
            HttpUrl httpUrl = request.url()
                    .newBuilder()
                    .addQueryParameter("api_key", apiKey)
                    .build();
            request = request.newBuilder()
                    .url(httpUrl)
                    .build();
            return chain.proceed(request);
        };
    }

    @Provides
    @Singleton
    public Gson provideGsonBuilder() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }

    @Provides
    @Singleton
    @Named(TAG_LOGGER_INTERCEPTOR)
    public Interceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    @Named(TAG_REST_JSON_INTERCEPTOR)
    public Interceptor provideRestJsonInterceptor() {
        return chain -> {
            Request request = chain.request();
            HttpUrl httpUrl = request.url()
                    .newBuilder()
                    .addQueryParameter("format", "json")
                    .addQueryParameter("nojsoncallback", "1")
                    .build();
            request = request.newBuilder()
                    .url(httpUrl)
                    .build();
            return chain.proceed(request);
        };
    }

    @Provides
    @Singleton
    public OkHttpClient provideHttpClient(@Named(TAG_API_KEY_INTERCEPTOR) Interceptor apiKeyInterceptor,
                                          @Named(TAG_LOGGER_INTERCEPTOR) Interceptor loggingInterceptor,
                                          @Named(TAG_REST_JSON_INTERCEPTOR) Interceptor restJsonInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(apiKeyInterceptor)
                .addInterceptor(restJsonInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client, @Named(TAG_BASE_URL) String baseUrl, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    @Provides
    @Singleton
    public FlickrApi provideApi(Retrofit retrofit) {
        return retrofit.create(FlickrApi.class);
    }
}
