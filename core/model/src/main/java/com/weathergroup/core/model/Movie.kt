package com.weathergroup.core.model

import kotlinx.datetime.Instant

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val language: String,
    val releaseDate: Instant,
    val posterUrl: String,
    val backgroundUrl: String,
    val rating: Float
)
