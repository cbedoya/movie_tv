package com.weathergroup.test.feature.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weathergroup.core.domain.GetNowPlayingMoviesUseCase
import com.weathergroup.core.domain.GetPopularMoviesUseCase
import com.weathergroup.core.domain.GetTopRatedMoviesUseCase
import com.weathergroup.core.domain.GetUpcomingMoviesUseCase
import com.weathergroup.test.model.Section
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
): ViewModel() {

    val content = combine(
        getNowPlayingMoviesUseCase().map { Section("Now Playing", it) },
        getPopularMoviesUseCase().map { Section("Popular", it) },
        getTopRatedMoviesUseCase().map { Section("Top Rated", it) },
        getUpcomingMoviesUseCase().map { Section("Upcoming", it) }
    ) { m1, m2, m3, m4 ->
        listOf(m1, m2, m3, m4)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )
}