package com.weathergroup.test.feature.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.tv.foundation.lazy.list.TvLazyColumn
import com.weathergroup.core.model.Movie

@Composable
fun CatalogScreen(
    viewModel: MovieViewModel = hiltViewModel(),
    onMovieClick: (Movie) -> Unit
) {
    val sections = viewModel.content.collectAsStateWithLifecycle().value
    TvLazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(sections.size) { i ->
            MovieSection(movies = sections[i].movies, onMovieClick = onMovieClick)
        }
    }
}