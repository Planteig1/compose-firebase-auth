package com.example.auth

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.auth.ui.Failure
import com.example.auth.ui.login.Login
import com.example.auth.ui.Success
import com.example.auth.ui.Welcome
import com.example.auth.ui.login.LoginViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            Welcome(
                getStarted = { navController.navigate("register") }
            )
        }
        composable(
            "register") {
            Login(
                onRegistrationSuccess = { navController.navigate("success")},
                onRegistrationFail = {navController.navigate("failure")},
                onLoginSuccess = { navController.navigate("success")},
            )
        }
        composable("success") {
            Success()
        }
        composable("failure") {
            Failure()
        }
    }
}