package com.example.lucky_wheel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lucky_wheel.screens.FrontScreen
import com.example.lucky_wheel.screens.GameScreen
import com.example.lucky_wheel.screens.LoseScreen

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
        composable(route = Screen.LoseScreen.route){
            LoseScreen(navController = navController)
        }
        composable(route = Screen.WinScreen.route){
            WinScreen(navController = navController)
        }
        }
    }


















/*

 */