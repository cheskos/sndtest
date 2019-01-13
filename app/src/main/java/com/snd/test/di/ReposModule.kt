package com.snd.test.di

import com.snd.test.http.ApiService
import com.snd.test.repositories.GifsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReposModule {

    @Provides @Singleton fun provideGifsRepo(
        apiService: ApiService
    ): GifsRepo = GifsRepo(apiService)

}