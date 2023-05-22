package com.weathergroup.core.network.di

import com.weathergroup.core.network.NetworkDataSource
import com.weathergroup.core.network.retrofit.RetrofitMovieDBNetwork
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun okHttpCallFactory(): Call.Factory = OkHttpClient.Builder()
        .addInterceptor(ApiInterceptor())
        .build()

}

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun RetrofitMovieDBNetwork.binds(): NetworkDataSource
}



class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3NWZjMWFlYWYyZjVkNTViZDU1NzVkMDY4OTExNDMyOCIsInN1YiI6IjY0Njk0MjgzYzM1MTRjMDEzYTU1YzQyYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.hTSD8bEEa8R_SgzRTV7fgO4gQd-RxQiOT75FGMwn3Xw")
        return chain.proceed(request.build())
    }
}