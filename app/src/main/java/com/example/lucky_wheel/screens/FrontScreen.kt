package com.example.lucky_wheel.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lucky_wheel.R
import com.example.lucky_wheel.Screen

@Composable
fun FrontScreen(navController: NavController) {
    var welcome = "Welcome to wheel of fortune!"
    Column (verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()

    ){
        Card(elevation = 2.dp){
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(
                    id = R.drawable.baggrund),
                contentDescription = null,

                modifier = Modifier
                    .height(20000.dp)
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(CenterHorizontally)
            ){
                Text(
                    welcome,
                    modifier = Modifier
                        .padding(75.dp)
                        .align(CenterHorizontally),
                    fontSize = 20.sp
                )

                Button(onClick = {
                    navController.navigate(Screen.GameScreen.route)
                },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Start Game")
                }

            }
        }

    }

}