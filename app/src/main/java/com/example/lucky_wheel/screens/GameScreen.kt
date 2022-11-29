package com.example.lucky_wheel.screens
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lucky_wheel.GameData.GameData._guessed
import com.example.lucky_wheel.GameData.GameData.guessed
import com.example.lucky_wheel.GameData.GameData.state
import com.example.lucky_wheel.R
import com.example.lucky_wheel.Screen
import com.example.lucky_wheel.ViewModel.ViewModel

@SuppressLint("UnrememberedMutableState", "MutableCollectionMutableState")
@Composable
fun GameScreen(navController: NavController){
    Column (
    ){
        _guessed.value.clear()
        var balance by remember { mutableStateOf(0) }
        var lives by remember {mutableStateOf(5)}
        var guess by remember { mutableStateOf(TextFieldValue("")) }
        var word by remember {mutableStateOf("")}
        var category by remember {mutableStateOf("")}
        var add by remember {mutableStateOf("")}
        val bankrupt by remember {mutableStateOf("BANKRUPT you have lost all your money")}
        var notBankrupt by remember {mutableStateOf("If you guess correctly, you will receive ")}
        var price by remember {mutableStateOf("Spin the wheel to see what price you can win!")}
        var payed = 0
        var currentWord = ""
        var newgame = 0

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
                Text(text = "Balance: $balance")
                Text(text = "Lives: $lives")

                Image(painter = painterResource(id = R.drawable.wheel), contentDescription = null,
                    modifier = Modifier
                        .align(CenterHorizontally)
                )

                Button(
                    onClick = {
                    if(newgame == 0){
                        category = ViewModel.getCategory.GetCategory()
                        word = ViewModel.getWord.GetWord(category)
                        currentWord = ViewModel.initializeWord.InitializeWord(word)
                        newgame = 1
                    }

                    if(state == 0) {
                        state = 1
                        add = ViewModel.spin.Spin()
                        if (add == "0"){
                            price = bankrupt
                            balance = 0
                            state = 0
                        }
                        if(add != "0"){
                            price = notBankrupt+add
                            state = 1
                        }

                    }
                },
                    modifier = Modifier
                        .padding(vertical = 25.dp)
                        .align(CenterHorizontally)

                )
                {
                    Text(text = "Spin the wheel!")
                }
                Text(price,
                    modifier = Modifier
                        .align(CenterHorizontally),
                    fontSize = 20.sp

                )

                TextField(
                    value = guess,
                    onValueChange = {guess = it},

                    modifier = Modifier
                        .align(CenterHorizontally)
                )
                Button(
                    onClick = {
                        if(guessed.value.contains(guess.text.toCharArray()[0]) && guess.text.length == 1) {
                            state = 0
                            lives -= 1
                            if(lives < 1){
                                navController.navigate(Screen.LoseScreen.route)
                            }
                        }

                        if (state == 1) {
                            if (guess.text.length > 1) {
                                if (guess.text == word) {
                                    balance += add.toInt()*word.length
                                    navController.navigate(Screen.WinScreen.route)
                                    payed = 1
                                }
                            }

                            if (guess.text.length == 1) {
                                ViewModel.addGuess.AddGuess(guess.text.toCharArray()[0])
                                if(ViewModel.validate.Validate(guess.text.toCharArray()[0],word)>0){
                                    balance+=add.toInt()* ViewModel.validate.Validate(guess.text.toCharArray()[0],word)
                                    currentWord = ViewModel.displayWord.DisplayWord(word,guess.text.toCharArray()[0],currentWord)
                                    payed = 1
                                    if(currentWord == word){
                                        navController.navigate(Screen.WinScreen.route)
                                    }
                                }
                                if (payed == 0) {
                                    lives -= 1
                                    if(lives < 1){
                                        navController.navigate(Screen.LoseScreen.route)
                                    }

                                }
                            }
                            payed = 0
                        }

                        state = 0


                    },
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .align(CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black,
                        contentColor = Color.White
                    ),
                ) {
                    Text(text = "GUESS!")
                }
                Text(
                    "Guessed letters: \n"+guessed.value.toString(),
                    modifier = Modifier
                        .align(CenterHorizontally),
                    fontSize = 20.sp
                )
                Text(
                    "Category:",
                    modifier = Modifier
                        .align(CenterHorizontally),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(category, modifier = Modifier
                        .align((CenterHorizontally)),

                )
                Text(
                    text = currentWord.toString(),
                    modifier = Modifier
                        .align(CenterHorizontally),
                    fontSize = 60.sp)
            }

        }


    }

}





