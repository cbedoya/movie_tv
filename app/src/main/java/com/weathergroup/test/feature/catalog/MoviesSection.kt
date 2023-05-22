package com.weathergroup.test.feature.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyRow
import com.weathergroup.core.model.Movie

@Composable
fun MovieSection(
    movies: List<Movie>,
    onMovieClick: (Movie) -> Unit,
) {
    TvLazyRow(
        modifier = Modifier
            .height(320.dp)
            .fillMaxWidth(),
        contentPadding = PaddingValues(start = 8.dp, top = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { i ->
            MovieCard(movie = movies[i], onMovieClick = onMovieClick)
        }
    }
}

/*@Preview("MovieCard")
@Composable
private fun MovieCardPreview() {
    WGTheme {
        Surface {
            MovieSection(
                listOf(
                    Movie(
                        0,
                        "Test",
                        "",
                        "",
                        Clock.System.now(),
                        "https://image.tmdb.org/t/p/original/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg",
                        "",
                        5.5f
                    ),
                    Movie(
                        1,
                        "Test 2",
                        "",
                        "",
                        Clock.System.now(),
                        "https://image.tmdb.org/t/p/original/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg",
                        "",
                        5.5f
                    ),
                    Movie(
                        2,
                        "Test 3",
                        "",
                        "",
                        Clock.System.now(),
                        "https://image.tmdb.org/t/p/original/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg",
                        "",
                        5.5f
                    )
                ),
                onMovieClick = {  }
            )
        }
    }
}*/