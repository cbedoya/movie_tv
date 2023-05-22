package com.weathergroup.core.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.weathergroup.core.network.NetworkDataSource
import com.weathergroup.core.network.model.NetworkMovie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitMovieDBNetworkApi {
    @GET("/3/movie/{filter}")
    suspend fun getMovies(
        @Path("filter") filter: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): NetworkResult<NetworkMovie>
}

@Serializable
private data class NetworkResult<T>(
    val page: Int,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int,
    val results: List<T>
)

@Singleton
class RetrofitMovieDBNetwork @Inject constructor(
    networkJson: Json,
    callFactory: Call.Factory
) : NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org")
        .callFactory(callFactory)
        .addConverterFactory(networkJson.asConverterFactory(MediaType.get("application/json")))
        .build()
        .create(RetrofitMovieDBNetworkApi::class.java)

    override suspend fun getNowPlaying(): List<NetworkMovie> =
        networkApi.getMovies("now_playing").results

    override suspend fun getPopular(): List<NetworkMovie> =
        networkApi.getMovies("popular").results

    override suspend fun getTopRated(): List<NetworkMovie> =
        networkApi.getMovies("top_rated").results

    override suspend fun getUpcoming(): List<NetworkMovie> =
        networkApi.getMovies("upcoming").results

}
