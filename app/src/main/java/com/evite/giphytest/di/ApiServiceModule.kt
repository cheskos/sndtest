package com.evite.giphytest.di

import com.evite.giphytest.http.GifsService
import com.evite.giphytest.http.HttpClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiServiceModule {

    @Provides @Singleton fun provideRetrofit(): Retrofit = HttpClient.get()

    @Provides @Singleton fun provideGifSearchService(retrofit: Retrofit): GifsService
            = retrofit.create(GifsService::class.java)

}