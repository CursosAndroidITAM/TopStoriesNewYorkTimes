package org.emilio.topstoriesnewyorktimes.service.api;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Emilio on 14/11/2016.
 */

public class NewYorkTimesAdapter {

    private static NewYorkTimesApiService newYorkTimesApiService;

    public static NewYorkTimesApiService getService(){

        if (newYorkTimesApiService==null){

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            Retrofit adapter = new Retrofit.Builder()
                    .baseUrl("https://api.nytimes.com/svc/topstories/v2/")
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .client(httpClient.build())
                    .build();

            newYorkTimesApiService = adapter.create(NewYorkTimesApiService.class);

        }

        return newYorkTimesApiService;
    }


}
