package com.weathergroup.test.feature.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.weathergroup.core.model.Movie
import com.weathergroup.test.R

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun DetailScreen(
    movie: Movie,
    modifier: Modifier = Modifier,
    onStartPlayback: (Movie) -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize()){
        AsyncImage(
            model = "https://image.tmdb.org/t/p/original" + movie.backgroundUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(32.dp)){
            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )
            Text(
                text = movie.description,
                color = Color.White
            )
            Button(onClick = { onStartPlayback(movie) }){
                Text(text = "Play")
            }
        }
    }
}