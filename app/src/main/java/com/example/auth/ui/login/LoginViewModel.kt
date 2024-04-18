package com.example.auth.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.auth.services.AccountService
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth


class LoginViewModel : ViewModel() {
    private val accountService: AccountService = AccountService();

    var username by mutableStateOf("")
        private set;

    var password by mutableStateOf("")
        private set;

    fun onUsernameChange(username: String) {
        this.username = username;
    }

    fun onPasswordChange(password: String) {
        this.password = password;
    }

    fun registerNewUser(navigateOnSuccess: () -> Unit, navigateOnFail: () -> Unit) {
        accountService.authenticate(username, password, navigateOnSuccess, navigateOnFail)
    }

    fun loginUser(navigateOnSuccess: () -> Unit) {
        accountService.login(username,password, navigateOnSuccess)
    }

}