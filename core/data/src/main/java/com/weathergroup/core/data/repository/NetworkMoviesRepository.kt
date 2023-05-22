package com.weathergroup.core.data.repository

import com.weathergroup.core.data.model.asMovies
import com.weathergroup.core.model.Movie
import com.weathergroup.core.network.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NetworkMoviesRepository @Inject constructor(
    private val network: NetworkDataSource
): MoviesRepository {

    override fun getNowPlaying(): Flow<List<Movie>> =
        flow { emit(network.getNowPlaying()) }.map { it.asMovies() }

    override fun getPopular(): Flow<List<Movie>> =
        flow { emit(network.getPopular()) }.map { it.asMovies() }

    override fun getTopRated(): Flow<List<Movie>> =
        flow { emit(network.getTopRated()) }.map { it.asMovies() }

    override fun getUpcoming(): Flow<List<Movie>> =
        flow { emit(network.getUpcoming()) }.map { it.asMovies() }
}