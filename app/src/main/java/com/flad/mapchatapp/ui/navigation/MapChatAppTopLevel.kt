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
   ){

    Scaffold {innerPadding->
       Nav(
           modifier = Modifier.padding(innerPadding)
       )

    }
}