package com.example.guestink.android.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardReturn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterAddressUser(onRegisterAddress: () -> Unit, onBackToSignIn: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Continuar Cadastro")
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
        Column {


        }
    }
}