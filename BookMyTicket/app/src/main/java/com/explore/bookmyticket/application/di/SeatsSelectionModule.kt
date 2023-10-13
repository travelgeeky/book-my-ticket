package com.explore.bookmyticket.application.di

import com.explore.bookmyticket.application.di.qualifier.BaseUrl
import com.explore.bookmyticket.data.api.SeatsSelectionApi
import com.explore.bookmyticket.data.repo.SeatsSelectionRepositoryImpl
import com.explore.bookmyticket.domain.repo.SeatsSelectionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SeatsSelectionModule {

    @Singleton
    @Provides
    @BaseUrl
    fun getBaseUrl(): String{
        return "https://run.mocky.io/"
    }

    @Provides
    fun getRetrofitInstance(@BaseUrl baseUrl: String): Retrofit{
        return Retrofit.Builder().
                        baseUrl(baseUrl).
                        addConverterFactory(GsonConverterFactory.create()).
                        build()
    }

    @Provides
    fun getApiService(retrofitInstance: Retrofit): SeatsSelectionApi {
        return retrofitInstance.create(SeatsSelectionApi::class.java)
    }

    @Provides
    fun getCatFactsRepository(seatsSelectionApi: SeatsSelectionApi): SeatsSelectionRepository {
        return SeatsSelectionRepositoryImpl(seatsSelectionApi)
    }
}