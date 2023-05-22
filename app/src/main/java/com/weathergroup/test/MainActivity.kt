package com.weathergroup.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.weathergroup.test.feature.catalog.CatalogScreen
import com.weathergroup.test.feature.catalog.MovieViewModel
import com.weathergroup.test.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalTvMaterial3Api::class)
@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                AppNavigation(navController = rememberNavController())
            }
        }
    }
}