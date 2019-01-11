package com.evite.giphytest.http

import com.evite.giphytest.model.SearchResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GifsService {

    @GET("gifs/search")
    fun search(@Query("q") keyword: String,
               @Query("api_key") apiKey: String) : Call<SearchResponseData>
}