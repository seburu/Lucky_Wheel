package com.example.lucky_wheel.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lucky_wheel.R
import com.example.lucky_wheel.Screen


@Composable
fun LoseScreen(navController: NavController) {
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
                Text(
                    text = "LOSER!!",
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
