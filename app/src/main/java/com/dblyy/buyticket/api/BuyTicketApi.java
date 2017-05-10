package com.dblyy.buyticket.api;

import com.google.gson.JsonObject;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：linyaye on 2017/4/24 14:54
 */

public interface BuyTicketAPI {

    int LIMIT = 20;

    @GET("Showtime/LocationMovies.api")
    Flowable<JsonObject> getBuyShowingList(
            @Query("locationId") String locationId
    );

    @GET("Movie/MovieComingNew.api")
    Flowable<JsonObject> getComingNewList(
            @Query("locationId") String locationId
    );
}
