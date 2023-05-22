package com.weathergroup.core.domain

import com.weathergroup.core.data.repository.MoviesRepository
import com.weathergroup.core.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {

    operator fun invoke(): Flow<List<Movie>> = moviesRepository.getTopRated()
}