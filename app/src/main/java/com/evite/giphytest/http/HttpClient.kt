package com.evite.giphytest.http

import com.evite.giphytest.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpClient {

    companion object {

        fun get(): Retrofit {

            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                    .addInterceptor(logInterceptor)
                .build()

            val gson = GsonBuilder()
//                    .registerTypeAdapter(object: TypeToken<Map<String, Double>>() {}.type, CoinDeserializer())
                .create()

            val cv = GsonConverterFactory.create(gson)

            return Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .client(client)
                .addConverterFactory(cv)
                .build()
        }
    }

}