package com.khomotsozwane.simple_service_library.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    final static String BASE_URL = "https://jsonplaceholder.typicode.com";

    private static ApiService apiService;
    private static Retrofit retrofit;
    private static Gson gson;

    private static Retrofit getRetrofit(){
        createGson();

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    public static ApiService getApiService(){
        return apiService == null ? createService() : apiService;
    }

    private static ApiService createService() {
        return getRetrofit().create(ApiService.class);
    }

    private static Gson createGson(){
        if(gson == null){
            gson = new GsonBuilder()
                    .setLenient()
                    .create();
        }
        return gson;
    }

}
