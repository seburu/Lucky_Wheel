package com.example.lucky_wheel

sealed class Screen(val route : String){

    object FrontScreen : Screen("front_screen")
    object GameScreen : Screen("game_screen")
    object LoseScreen : Screen("lose_screen")
    object WinScreen : Screen("win_screen")

}
