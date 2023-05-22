package com.weathergroup.core.network

import com.weathergroup.core.network.model.NetworkMovie

interface NetworkDataSource {
    suspend fun getNowPlaying(): List<NetworkMovie>
    suspend fun getPopular(): List<NetworkMovie>
    suspend fun getTopRated(): List<NetworkMovie>
    suspend fun getUpcoming(): List<NetworkMovie>
}