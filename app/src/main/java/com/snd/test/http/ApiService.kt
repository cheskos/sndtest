package com.snd.test.http

import com.snd.test.model.PostResponseData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getAllPhotos() : Call<PostResponseData>
}