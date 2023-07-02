package com.dranoer.gpt.di

import com.dranoer.gpt.domain.ArtRepository
import com.dranoer.gpt.networking.WebService
import com.dranoer.gpt.networking.mapper.ArtMapper
import com.dranoer.gpt.networking.mapper.DetailMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRepository(
        webService: WebService,
        artMapper: ArtMapper,
        detailMapper: DetailMapper,
    ) = ArtRepository(service = webService, artMapper = artMapper, detailMapper = detailMapper)

    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO
}