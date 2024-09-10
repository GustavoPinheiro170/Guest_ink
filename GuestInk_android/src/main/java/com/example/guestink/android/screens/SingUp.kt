package com.example.guestink.android.screens

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.guestink.android.MyApplicationTheme
import com.example.guestink.android.services.User
import com.example.guestink.android.components.DropdownList


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(onBackToSignIn: () -> Unit, onRegisterUser: (User) -> Unit) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Registrar-se")

            },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackToSignIn()
                    }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardReturn,
                            contentDescription = "Voltar ao Login"
                        )
                    }
                })
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
            val context = LocalContext.current
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

            var selectedOption by remember { mutableStateOf("") }



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
                    Icon(imageVector = Icons.Default.Password, contentDescription = "Senha")
                }
            )

            OutlinedTextField(
                label = {
                    Text(text = "Confirmar Senha")
                },

                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
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
                    Icon(
                        imageVector = Icons.Default.Password,
                        contentDescription = "Confirmar Senha"
                    )
                }
            )


            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                val itemList = listOf<String>(
                    "Realizar meus trabalhos",
                    "Alugar meu espaço"
                )
                var selectedIndex by rememberSaveable { mutableStateOf(0) }
                var buttonModifier = Modifier.fillMaxWidth()

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // drop down list
                    Text("O que está buscando conosco?")
                    DropdownList(
                        itemList = itemList,
                        selectedIndex = selectedIndex,
                        modifier = buttonModifier,
                        onItemClick = { selectedIndex = it })

                    Row(
                        Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                    }
                }


                Button(
                    shape = ButtonDefaults.elevatedShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                    ),
                    onClick = {
                        onRegisterUser(
                            User(
                                password = password,
                                email = email,
                                name = nome,
                                typeProfile = itemList[selectedIndex]
                            )
                        )
                    },

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
    }


}



