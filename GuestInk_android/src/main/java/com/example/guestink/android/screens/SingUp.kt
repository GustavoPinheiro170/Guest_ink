package com.example.guestink.android.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guestink.android.MyApplicationTheme


@Composable
fun SignUp() {
    Column(
        modifier = Modifier.background(Color.White).fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var email by remember {
            mutableStateOf("")
        }
        var nome by remember {
            mutableStateOf("")
        }
        var perfilArtista by remember {
            mutableStateOf(value = false)
        }
        var confirmPassword by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }

        var showPassword by remember { mutableStateOf(value = false) }


        OutlinedTextField(
            label = {
                Text(text = "Nome")
            },
            value = nome,
            onValueChange = {
                nome = it
            }, modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Nome")
            }
        )


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

        OutlinedTextField(
            label = {
                Text(text = "Senha")
            },

            value = password,
            onValueChange = {
                password = it
            },
            visualTransformation = if (showPassword)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "hide_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                }
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Password, contentDescription = "E-mail")
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
            Text(text = "Cadastrar-se")
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

@Preview
@Composable
private fun SignUpScreen() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            SignUp()
        }
    }
}
