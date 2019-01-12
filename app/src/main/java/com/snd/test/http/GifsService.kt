package com.snd.test.http

import com.snd.test.model.SearchResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GifsService {

    @GET("gifs/search")
    fun search(@Query("q") keyword: String,
               @Query("offset") offset: Int,
               @Query("limit") limit: Int,
               @Query("api_key") apiKey: String) : Call<SearchResponseData>
}