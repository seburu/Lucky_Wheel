package com.example.lucky_wheel.ViewModel

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.example.lucky_wheel.GameData
import com.example.lucky_wheel.GameData.GameData._guessed
import com.example.lucky_wheel.Screen
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
        fun Validate(guess: Char,word: String): Int{
            var j = 0
            for (i in 0 until word.toCharArray().size) {
                if(guess == word.toCharArray()[i]){
                    j++
                }
            }
            return j
        }


        fun AddGuess(guess: Char){
            _guessed.value.add(guess)
        }

        fun Spin(): String {
            val prices = listOf(0, 50, 100, 150, 250, 500, 1000, 2000)
            val price = prices[(Math.random() * 8).toInt()]
            return price.toString()
        }


        fun GetWord(category: String): String {
            var words = listOf(
                GameData.GameData.countries,
                GameData.GameData.foods,
                GameData.GameData.sports,
                GameData.GameData.clothing,
                GameData.GameData.animals
            )

            var word = ""
            for (i in words.indices) {
                if (words[i][0] == category) {
                    word = words[i][(Math.random() * (words[i].size-1)+1).toInt()]
                }
            }
            return word
        }

        fun GetCategory(): String {
            var category = listOf<String>("countries", "foods", "sports", "clothing", "animals")
            return category[(Math.random() * category.size).toInt()]
        }


        fun InitializeWord(word: String): String{
            var current = ""
            for(i in word.indices){
                current+='-'
            }
            return current
        }


        fun DisplayWord(word: String, guess: Char, current: String): String{
            var newCur = StringBuilder(current)

            for (i in 0 until word.toCharArray().size) {
                if(guess == word.toCharArray()[i]){
                    newCur.setCharAt(i,guess)

                }
            }
            return newCur.toString()
        }

    @Composable
    fun doTurn(navController:NavController) {
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

        if((GameData.GameData.guessed.value.contains(guess.text.toCharArray()[0]) && guess.text.length == 1 ||
                    guess.text.length > 1 && guess.text!=word) && GameData.GameData.state ==1) {
            GameData.GameData.state = 0
            lives -= 1
            if(lives < 1){
                navController.navigate(Screen.LoseScreen.route)
            }
        }

        if (GameData.GameData.state == 1) {
            if (guess.text.length > 1) {
                if (guess.text == word) {
                    balance += add.toInt()*word.length
                    navController.navigate(Screen.WinScreen.route)
                    payed = 1
                }
            }

            if (guess.text.length == 1) {
                AddGuess(guess.text.toCharArray()[0])
                if(Validate(guess.text.toCharArray()[0],word)>0){
                    balance+=add.toInt()* Validate(guess.text.toCharArray()[0],word)
                    currentWord = DisplayWord(word,guess.text.toCharArray()[0],currentWord)
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

        GameData.GameData.state = 0


    }



}
