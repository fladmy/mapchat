package com.flad.mapchatapp.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.flad.mapchatapp.ui.composables.login.LoginScreen
import com.flad.mapchatapp.ui.composables.login.LoginViewModel

fun NavGraphBuilder.authGraph(
    navController: NavHostController
    ){
    navigation(
        startDestination = MapChatNestedScreansRoutes.LoginScreen.route,
        route = MapChatNestedScreansRoutes.AuthRoute.route)
    {
        composable(
            route = MapChatNestedScreansRoutes.LoginScreen.route
        ){
            LoginScreen(
                onSucessNavigate =
                {navController.navigate(route = MapChatNestedScreansRoutes.AppRoute.route)}
            )
        }

    }
}