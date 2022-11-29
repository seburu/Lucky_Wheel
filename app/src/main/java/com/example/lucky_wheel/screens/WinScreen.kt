package com.example.lucky_wheel

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lucky_wheel.GameData
import com.example.lucky_wheel.GameData.GameData._guessed
import com.example.lucky_wheel.GameData.GameData.guessed
import com.example.lucky_wheel.GameData.GameData.state
import com.example.lucky_wheel.R
import com.example.lucky_wheel.Screen
import com.example.lucky_wheel.ViewModel.ViewModel

@Composable
fun WinScreen(navController: NavController){
    Column (verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Card(elevation = 2.dp) {
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(
                    id = R.drawable.baggrund
                ),
                contentDescription = null,

                modifier = Modifier
                    .height(20000.dp)
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(CenterHorizontally)

            ) {
                Text(text = "WINNER!!",
                    fontSize = 50.sp,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .align(CenterHorizontally)
                )

                Button(onClick = {
                    navController.navigate(Screen.GameScreen.route)
                },
                    modifier = Modifier
                        .align(CenterHorizontally)
                ) {
                    Text(text = "Play again?")
                }

            }
        }
    }

}

