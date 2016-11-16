package org.emilio.topstoriesnewyorktimes.service.api;

import com.google.gson.JsonObject;

import org.emilio.topstoriesnewyorktimes.util.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Emilio on 14/11/2016.
 */

public interface NewYorkTimesApiService {

    @Headers({Constants.HEADER_API})
    @GET("/food.json")
    Call<JsonObject> getFoodTopStories();

    @GET("/movies.json")
    Call<JsonObject> getMoviesTopStories();
}
