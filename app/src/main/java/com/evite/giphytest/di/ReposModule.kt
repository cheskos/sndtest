package com.evite.giphytest.di

import com.evite.giphytest.http.GifsService
import com.evite.giphytest.repositories.GifsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReposModule {

    @Provides @Singleton fun provideGifsRepo(
        gifsService: GifsService
    ): GifsRepo = GifsRepo(gifsService)

}