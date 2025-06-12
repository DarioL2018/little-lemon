package com.littlelemon.little_lemon_app

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.littlelemon.little_lemon_app.data.UserPreferences

@Composable
fun Navigation(navController: NavHostController, database: AppDatabase) {
    val isUserRegistered = UserPreferences.isUserRegistered(LocalContext.current)

    NavHost(
        navController = navController,
        startDestination = if (isUserRegistered) Home.route else Onboarding.route
    ) {
        composable(Onboarding.route) {
            Onboarding(navController = navController)
        }
        composable(Home.route) {
            HomeScreen(navController, database)
        }
        composable(Profile.route) {
            Profile(navController)
        }
    }
}