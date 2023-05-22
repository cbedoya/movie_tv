package com.weathergroup.core.data.model

import com.weathergroup.core.model.Movie
import com.weathergroup.core.network.model.NetworkMovie

fun NetworkMovie.asMovie() = Movie(
    id = id,
    title = title,
    description = overview,
    language = originalLanguage,
    releaseDate = releaseDate,
    posterUrl = posterPath,
    backgroundUrl = backdropPath,
    rating = voteAverage
)

fun List<NetworkMovie>.asMovies() = this.map { it.asMovie() }