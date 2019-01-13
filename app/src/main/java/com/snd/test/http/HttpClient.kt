package com.snd.test.http

import com.snd.test.Constants
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.snd.test.model.AlbumResponseData
import com.snd.test.model.PostResponseData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpClient {
    fun get(): Retrofit {

        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .build()

        val gson = GsonBuilder()
            .registerTypeAdapter(object : TypeToken<Array<List<PostResponseData>>>(){}.type, JsonArrayDeserializer())
            .create()

        val cv = GsonConverterFactory.create(gson)

        return Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            .client(client)
            .addConverterFactory(cv)
            .build()
    }

}