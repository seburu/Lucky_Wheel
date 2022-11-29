package com.example.lucky_wheel.ViewModel

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.example.lucky_wheel.GameData
import com.example.lucky_wheel.GameData.GameData._guessed
import com.example.lucky_wheel.Screen

class ViewModel {
    object validate{
        fun Validate(guess: Char,word: String): Int{
            var j = 0
            for (i in 0 until word.toCharArray().size) {
                if(guess == word.toCharArray()[i]){
                    j++
                }
            }
            return j
        }
    }

    object addGuess{
        fun AddGuess(guess: Char){
            _guessed.value.add(guess)
        }
    }
    object spin{
        fun Spin(): String {
            val prices = listOf(0, 50, 100, 150, 250, 500, 1000, 2000)
            val price = prices[(Math.random() * 8).toInt()]
            return price.toString()
        }
    }
    object getWord {

        fun GetWord(category: String): String {
            var words = listOf<List<String>>(
                GameData.GameData.countries,
                GameData.GameData.foods,
                GameData.GameData.sports,
                GameData.GameData.clothing,
                GameData.GameData.animals
            )

            var word = ""
            for (i in words.indices) {
                if (words[i][0] == category) {
                    word = words[i][(Math.random() * 4+1).toInt()]
                }
            }
            return word
        }
    }
    object getCategory{
        fun GetCategory(): String {
            var category = listOf<String>("countries", "foods", "sports", "clothing", "animals")
            return category[(Math.random() * 5).toInt()]
        }
    }

    object initializeWord{
        fun InitializeWord(word: String): String{
            var current = ""
            for(i in 0 until word.toCharArray().size){
                current+='-'
            }
            return current
        }
    }

    object displayWord{
        fun DisplayWord(word: String, guess: Char, current: String): String{
            var newCur = StringBuilder(current)

            for (i in 0 until word.toCharArray().size) {
                if(guess == word.toCharArray()[i]){
                    newCur.setCharAt(i,guess)

                }
            }
            return newCur.toString()
        }
    }


}
