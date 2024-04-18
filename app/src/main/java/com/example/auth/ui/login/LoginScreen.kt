package com.example.auth.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Login(
    onRegistrationSuccess: () -> Unit,
    onRegistrationFail: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    val loginViewModel: LoginViewModel = viewModel()

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Username")
            TextField(
                value = loginViewModel.username,
                onValueChange = { loginViewModel.onUsernameChange(it) })

            Text("Password")
            TextField(
                value = loginViewModel.password,
                onValueChange = { loginViewModel.onPasswordChange(it) })

            Row {
                Button(
                    onClick = { loginViewModel.loginUser(navigateOnSuccess = onLoginSuccess)
                }) {
                    Text("Login")
                }
                Button(onClick = {
                    loginViewModel.registerNewUser(
                        navigateOnSuccess = onRegistrationSuccess,
                        navigateOnFail = onRegistrationFail
                    )
                }) {
                    Text("Create new user")
                }
            }

        }
    }
}