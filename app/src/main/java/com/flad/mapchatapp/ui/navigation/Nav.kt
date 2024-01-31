package com.flad.mapchatapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.flad.mapchatapp.ui.composables.homepage.HomePage
import com.flad.mapchatapp.ui.composables.login.LoginScreen
import com.flad.mapchatapp.ui.composables.login.LoginViewModel

@Composable
fun Nav(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = MapChatNestedScreansRoutes.AuthRoute.route,
        modifier = modifier
    ){

       authGraph(navController = navController)
        appGraph(navController = navController)

        }




    }

