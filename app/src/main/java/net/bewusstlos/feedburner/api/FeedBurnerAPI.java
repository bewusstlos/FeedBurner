package net.bewusstlos.feedburner.api;


import net.bewusstlos.feedburner.models.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bewusstlos on 10/31/2017.
 */

public interface FeedBurnerAPI {
    @GET("hsDu")
    Call<Feed> feed();
}
