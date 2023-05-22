package com.weathergroup.test.feature.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.weathergroup.core.model.Movie
import com.weathergroup.core.model.getYear
import com.weathergroup.test.R

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieCard(
    movie: Movie,
    onMovieClick: (Movie) -> Unit
) {
    Card(
        onClick = { onMovieClick(movie) },
        modifier = Modifier
            .clickable {
                onMovieClick(movie)
            }

    ) {
        Column(
            modifier = Modifier
                .width(128.dp)
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/original" + movie.posterUrl,
                contentDescription = null,
                modifier = Modifier.aspectRatio(9f.div(16)),
                contentScale = ContentScale.Crop
            )
            Text(
                movie.title,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp).padding(top = 8.dp),
                maxLines = 1,
                style = MaterialTheme.typography.labelLarge
            )
            Row(
                modifier = Modifier.padding(all = 8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    "${movie.releaseDate.getYear()}",
                    color = Color.White,
                    maxLines = 1,
                    style = MaterialTheme.typography.labelMedium
                )
                Spacer(modifier = Modifier.weight(1.0f))
                Image(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    "${movie.rating}",
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}