package com.snd.test.di

import com.snd.test.http.GifsService
import com.snd.test.repositories.GifsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReposModule {

    @Provides @Singleton fun provideGifsRepo(
        gifsService: GifsService
    ): GifsRepo = GifsRepo(gifsService)

}