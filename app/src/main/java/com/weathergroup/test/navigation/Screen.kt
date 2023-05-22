package com.weathergroup.test.navigation

sealed class Screen(val title: String) {
    object Catalog: Screen("Catalog")
    object Detail: Screen("Detail")
    object Player: Screen("Player")
}
