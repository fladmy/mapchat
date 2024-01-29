package com.flad.mapchatapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flad.mapchatapp.ui.composables.homepage.HomePage
import com.flad.mapchatapp.ui.composables.login.LoginScreen
import com.flad.mapchatapp.ui.composables.login.LoginViewModel

@Composable

fun MapchatAppTopLevel(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel
){

    Scaffold {innerPadding->
        NavHost(
            navController = navController,
            startDestination = MapChatScreenRoutes.Login.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(
                route = MapChatScreenRoutes.Login.name
            ){
                LoginScreen(onSucessNavigate = {navController.navigate(route = MapChatScreenRoutes.Home.name)}, loginViewModel = loginViewModel)

            }

            composable(route = MapChatScreenRoutes.Home.name){
                HomePage()
            }

        }

    }
}