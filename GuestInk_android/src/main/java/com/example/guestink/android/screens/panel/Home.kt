package com.example.guestink.android.screens.panel

import RequestLocationPermission
import android.annotation.SuppressLint
import android.provider.CalendarContract.Colors
import android.widget.ScrollView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.guestink.android.MyApplicationTheme
import com.example.guestink.android.models.User
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@SuppressLint(
    "UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState",
    "RestrictedApi"
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(onBackToSignIn: () -> Unit, user: User?, location: Pair<Double, Double>?) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Bem-vindo ${user?.username}")
            },
                navigationIcon = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = {
                        }) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Painel principal"
                            )
                        }
                        IconButton(onClick = {
                            onBackToSignIn()
                        }) {
                            Icon(
                                imageVector = Icons.Default.Logout,
                                contentDescription = "Voltar para tela de login",
                            )

                        }
                    }


                })
        },
        content = {
            Column {
                Box(
                    Modifier
                        .fillMaxHeight(.4f)
                        .fillMaxWidth()
                        .fillMaxSize()
                ) {
                    val userLocation = location?.let { it1 -> LatLng(it1.first, location.second) }
                    val cameraPositionState = rememberCameraPositionState {
                        position = CameraPosition.fromLatLngZoom(userLocation!!, 10f)
                    }
                    GoogleMap(
                        modifier = Modifier
                            .fillMaxSize(),
                        cameraPositionState = cameraPositionState
                    ) {
                        Marker(
                            state = MarkerState(position = userLocation!!),
                            title = "Singapore",
                            snippet = "Marker in Singapore"
                        )
                    }

                }
                ScrollableList()
            }
        },
        contentColor = Color.Gray
    )


}


@Composable
fun CardStudios() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Gray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(3.dp)
    ) {
        Text(text = "Hello, world!")
    }
}

@Composable
fun ScrollableList() {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        repeat(100) { index ->
            CardStudios()
        }
    }
}

@Preview
@Composable
private fun HomeScreen() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Home(
                onBackToSignIn = {},
                location = Pair(0.0, 0.0),
                user = User("teste", "")
            )
        }
    }
}
