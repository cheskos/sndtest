package com.snd.test.http

import com.snd.test.model.CommentResponseData
import com.snd.test.model.PostResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("posts")
    fun getAllPosts() : Call<List<PostResponseData.Post>>

    @GET("comments")
    fun getCommentsFor(@Query("postId")id: Int) : Call<List<CommentResponseData.Comment>>
}