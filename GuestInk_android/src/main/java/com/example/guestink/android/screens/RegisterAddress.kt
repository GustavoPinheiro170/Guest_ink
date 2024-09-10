package com.example.guestink.android.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardReturn
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guestink.android.MyApplicationTheme
import com.example.guestink.android.services.GetCEPService
import com.example.guestink.android.services.User
import com.example.guestink.android.services.fetchCEP


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterAddressUser(onRegisterAddress: () -> Unit, onBackToRegister: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Cadastrar Endereço")
            },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackToRegister()
                    }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardReturn,
                            contentDescription = "Voltar ao Login"
                        )
                    }
                })
        },
        content = {

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var cep by remember {
                    mutableStateOf("")
                }
                var logradouro by remember {
                    mutableStateOf("")
                }
                var bairro by remember {
                    mutableStateOf("")
                }
                var localidade by remember {
                    mutableStateOf("")
                }
                var estado by remember {
                    mutableStateOf("")
                }
                var uf by remember {
                    mutableStateOf("")
                }
                var numero by remember {
                    mutableStateOf("")
                }
                var colorBgDisable = Color(0xFFE6E6E6)

                OutlinedTextField(
                    label = {
                        Text(text = "CEP")
                    },
                    value = cep,

                    onValueChange = {
                        if (it.length == 8) {
                            cep = it;
                            fetchCEP(it, onSuccess = {
                                logradouro = it.logradouro.toString()
                                bairro = it.bairro.toString()
                                localidade = it.localidade.toString()
                                estado = it.estado.toString()
                                uf = it.uf.toString()
                            },
                                onFailure = {})
                        }
                        if (it.length <= 8) {
                            cep = it;
                        }
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = "CEP")
                    }
                )

                OutlinedTextField(
                    label = {
                        Text(text = "Logradouro")
                    },
                    value = logradouro,
                    onValueChange = {
                        logradouro = it
                    }, modifier = Modifier
                        .padding(8.dp)
                        .background(color = colorBgDisable)
                        .fillMaxWidth(),
                    readOnly = true
                )

                OutlinedTextField(
                    label = {
                        Text(text = "Bairro")
                    },
                    value = bairro,
                    onValueChange = {
                        bairro = it
                    }, modifier = Modifier
                        .padding(8.dp)
                        .background(color = colorBgDisable)
                        .fillMaxWidth(),
                    readOnly = true
                )

                OutlinedTextField(
                    label = {
                        Text(text = "Localidade")
                    },
                    value = localidade,
                    onValueChange = {
                        localidade = it
                    }, modifier = Modifier.run {
                        padding(8.dp)
                            .background(color = colorBgDisable)
                            .fillMaxWidth()
                    },
                    readOnly = true
                )
                OutlinedTextField(
                    label = {
                        Text(text = "Estado")
                    },
                    value = estado,
                    onValueChange = {
                        estado = it
                    }, modifier = Modifier
                        .padding(8.dp)
                        .background(color = colorBgDisable)
                        .fillMaxWidth(),
                    readOnly = true
                )
                OutlinedTextField(
                    label = {
                        Text(text = "UF")
                    },
                    value = uf,
                    onValueChange = {
                        uf = it
                    }, modifier = Modifier
                        .padding(8.dp)
                        .background(color = colorBgDisable)
                        .fillMaxWidth(),
                    readOnly = true
                )

                OutlinedTextField(
                    label = {
                        Text(text = "Numero")
                    },
                    value = numero,
                    onValueChange = {
                        numero = it
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                )

                Button(
                    shape = ButtonDefaults.elevatedShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                    ),
                    onClick = {
                        onRegisterAddress()
                    },

                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),

                    ) {
                    Text(text = "Finalizar Cadastro")
                }
            }
        })


}

@Preview
@Composable
private fun AuthScreenPreview() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            RegisterAddressUser(onBackToRegister = {}, onRegisterAddress = {})
        }
    }
}