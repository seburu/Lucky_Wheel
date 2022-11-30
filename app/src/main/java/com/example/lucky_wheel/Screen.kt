package com.example.lucky_wheel


//THIS SCREEN CLASS HAS WAS MADE WITH INSPIRATION FROM THE YOUTUBE VIDEO:
//https://www.youtube.com/watch?v=4gUeyNkGE3g&t=707s
sealed class Screen(val route : String){

    object FrontScreen : Screen("front_screen")
    object GameScreen : Screen("game_screen")
    object LoseScreen : Screen("lose_screen")
    object WinScreen : Screen("win_screen")

    fun withArgs(vararg args : String): String{

        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}
