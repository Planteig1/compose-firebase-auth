package com.example.auth.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Success(){
    Box(Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column {
            val email = FirebaseAuth.getInstance().currentUser!!.email
            Text("Success 🚀");
            Text(email!!)
        }
    }
}
