package com.example.guestink.android.screens


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardReturn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.guestink.android.MyApplicationTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecoveryAccount(onBackToSignIn: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Recuperar Acesso")
            },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackToSignIn()
                    }) {
                        Icon(imageVector = Icons.Default.KeyboardReturn, contentDescription = "Voltar ao Login" )
                    }
                }  )
        },

        ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var email by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                label = {
                    Text(text = "E-mail")
                },
                value = email,
                onValueChange = {
                    email = it
                }, modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "E-mail")
                }
            )

            Button(
                shape = ButtonDefaults.elevatedShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                ),
                onClick = { },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),

                ) {
                Text(text = "Recuperar")
            }
            Row(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

            }

        }

    }

}

@Preview
@Composable
private fun RecoveryAccountScreen() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            RecoveryAccount(onBackToSignIn = {})
        }
    }
}
