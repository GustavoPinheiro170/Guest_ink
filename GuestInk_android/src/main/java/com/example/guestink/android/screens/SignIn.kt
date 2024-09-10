package com.example.guestink.android.screens

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guestink.android.MyApplicationTheme
import com.example.guestink.android.R
import com.example.guestink.android.models.User
import com.example.guestink.android.utils.OrionObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun SignInScreen(
    onSignUpClick: () -> Unit,
    onRecoveryClick: () -> Unit,
    onEntryAccount: (User) -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var showPassword by remember { mutableStateOf(value = false) }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {



        Image(
            modifier = Modifier.fillMaxWidth(0.4f),
            painter = painterResource(id = R.drawable.logo_guest),
            contentDescription = "Logotipo Guest Ink"
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
            onClick = {
                logUserAndPassword(email, password)
                onEntryAccount(User(email, password))
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),

            ) {
            Text(text = "Entrar")
        }
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                onClick = {
                    onSignUpClick()
                })
            {
                Text(text = "Cadastrar-se")
            }
            TextButton(
                onClick = onRecoveryClick
            ) {
                Text(text = "Recuperar Acesso")
            }
        }

    }


}


private fun logUserAndPassword(user: String, password: String) {
    Log.d("Usuario", user)
    Log.d("Senha", password)
}

@Preview
@Composable
private fun AuthScreenPreview() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            SignInScreen(onSignUpClick = {}, onRecoveryClick = {}, onEntryAccount = {})
        }
    }
}
