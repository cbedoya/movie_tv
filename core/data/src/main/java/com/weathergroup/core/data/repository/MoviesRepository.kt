package com.weathergroup.core.data.repository

import com.weathergroup.core.model.Movie
import kotlinx.coroutines.flow.Flow
interface MoviesRepository {

    fun getNowPlaying(): Flow<List<Movie>>

    fun getPopular(): Flow<List<Movie>>

    fun getTopRated(): Flow<List<Movie>>

    fun getUpcoming(): Flow<List<Movie>>
}