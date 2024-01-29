package com.flad.mapchatapp.ui.composables.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.flad.mapchatapp.model.repository.authrepository.eventhandler.AuthUiEvent
import com.flad.mapchatapp.ui.navigation.MapChatScreenRoutes

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onSucessNavigate:()->Unit,
){

    val email by loginViewModel.email
    val password by loginViewModel.password

    val eventHolder by loginViewModel.eventFlow.collectAsState(initial = AuthUiEvent.InitialState(""))

    loginViewModel.authResponseData.value.let {
        if (it!=null)onSucessNavigate()
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = email,
            onValueChange = loginViewModel::onEmailChange,
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = loginViewModel::onPasswordChange,
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = loginViewModel::signInWithEmailAndPassword,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Login")
        }

        when (eventHolder) {
            is AuthUiEvent.Loading -> CircularIndeterminateProgressBar()
            is AuthUiEvent.AuthFail -> Text(text = (eventHolder as AuthUiEvent.AuthFail).message, color = Color.Red)
            else -> {}
        }
    }

    }


@Composable
fun CircularIndeterminateProgressBar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}
