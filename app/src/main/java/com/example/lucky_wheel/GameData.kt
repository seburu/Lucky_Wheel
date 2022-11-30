package com.example.lucky_wheel

import android.annotation.SuppressLint
import androidx.compose.runtime.*

class GameData {

    object GameData{
        val countries = listOf<String>("countries","denmark", "norway", "usa", "brazil", "germany")
        val foods = listOf<String>("foods","burger", "pizza", "pasta", "sushi", "brownie")
        val sports = listOf<String>("sports","soccer", "handball", "hockey", "baseball", "golf")
        val clothing = listOf<String>("clothing","pants", "shirt", "shoes", "underwear", "hat")
        val animals = listOf<String>("animals","dog", "horse", "cheetah", "monkey", "swan")

        var state = 0

        @SuppressLint("MutableCollectionMutableState")
        val _guessed: MutableState<MutableList<Char>> = mutableStateOf(mutableListOf(' '))

        var guessed: State<List<Char>> = _guessed
    }





}