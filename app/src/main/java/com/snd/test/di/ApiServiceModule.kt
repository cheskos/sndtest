package com.snd.test.di

import com.snd.test.http.ApiService
import com.snd.test.http.HttpClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiServiceModule {

    @Provides @Singleton fun provideRetrofit(): Retrofit = HttpClient.get()

    @Provides @Singleton fun provideGifSearchService(retrofit: Retrofit): ApiService
            = retrofit.create(ApiService::class.java)

}