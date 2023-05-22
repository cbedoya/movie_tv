package com.weathergroup.test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.weathergroup.core.model.Movie
import com.weathergroup.test.feature.catalog.CatalogScreen
import com.weathergroup.test.feature.detail.DetailScreen
import com.weathergroup.test.feature.player.PlayerScreen
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.toLocalDate
import kotlinx.datetime.toLocalTime

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Catalog.title) {
        composable(Screen.Catalog.title) {
            CatalogScreen(onMovieClick = { navController.navigateTo(Screen.Detail.title) })
        }
        composable(
            Screen.Detail.title,
        ) {
            //TODO: use id argument and DetailScreen should fetch the movie info
            DetailScreen(movie = Movie(
                1,
                "The Super Mario Bros. Movie",
                "While working underground to fix a water main, Brooklyn plumbers—and brothers—Mario and Luigi are transported down a mysterious pipe and wander into a magical new world. But when the brothers are separated, Mario embarks on an epic quest to find Luigi.",
                "en",
                "2023-04-05".toLocalDate().atStartOfDayIn(TimeZone.currentSystemDefault()),
                "/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg",
                "/nLBRD7UPR6GjmWQp6ASAfCTaWKX.jpg",
                7.7f,
            )) {
                navController.navigateTo(Screen.Player.title)
            }
        }
        composable(
            Screen.Player.title
        ) {
            //TODO: should receive movie url as navigation argument
            PlayerScreen(movieUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
        }
    }
}

fun NavHostController.navigateTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateTo.graph.findStartDestination().id
        ) {
            saveState = true
            inclusive = true
        }
        launchSingleTop = true
        restoreState = true
    }