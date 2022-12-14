package com.example.lucky_wheel
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lucky_wheel.screens.FrontScreen
import com.example.lucky_wheel.screens.GameScreen
import com.example.lucky_wheel.screens.LoseScreen


//THIS NAVIGATOR KOTLIN FILE HAS WAS MADE WITH INSPIRATION FROM THE YOUTUBE VIDEO:
//https://www.youtube.com/watch?v=4gUeyNkGE3g&t=707s
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen.FrontScreen.route){
        composable(route = Screen.FrontScreen.route){
            FrontScreen(navController = navController)
        }
        composable(
            route = Screen.GameScreen.route){
            GameScreen(navController = navController)
        }
        composable(
            route = Screen.WinScreen.route+"/{pricemoney}",
        arguments = listOf(navArgument("pricemoney"){
            type = NavType.StringType
            defaultValue = ""
        }
        )
        ) {entry ->
            entry.arguments?.getString("pricemoney")
                ?.let { WinScreen(pricemoney = it,navController = navController) }
        }
        composable(route = Screen.LoseScreen.route){
            LoseScreen(navController = navController)
        }
        }
    }

















/*

 */