package com.flad.mapchatapp.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.flad.mapchatapp.ui.composables.homepage.HomePage
import com.flad.mapchatapp.ui.composables.login.LoginViewModel

fun NavGraphBuilder.appGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = MapChatNestedScreansRoutes.HomePage.route,
        route = MapChatNestedScreansRoutes.AppRoute.route
    ) {
        composable(route = MapChatNestedScreansRoutes.HomePage.route)
        {
            HomePage()
        }

    }
}