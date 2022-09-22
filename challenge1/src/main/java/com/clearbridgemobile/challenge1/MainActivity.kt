package com.clearbridgemobile.challenge1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clearbridgemobile.challenge1.components.HomeScreen
import com.clearbridgemobile.challenge1.components.WelcomeScreen
import com.clearbridgemobile.challenge1.theme.AndroidInterviewTheme
import com.clearbridgemobile.challenge1.util.Screen


class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var sharedPreference: SharedPreferences

    companion object {
        const val IS_WELCOME_SCREEN_SHOWN = "IS_WELCOME_SCREEN_SHOWN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference =
            getSharedPreferences("ANDROID_INTERVIEW", Context.MODE_PRIVATE)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }

        setContent {
            AndroidInterviewTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = provideStartDestination()
                ) {
                    composable(route = Screen.WelcomeScreen.route) {
                        WelcomeScreen(navController = navController)
                    }
                    composable(route = Screen.HomeScreen.route) {
                        HomeScreen()
                    }
                }
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    if (destination.route == Screen.HomeScreen.route) {
                        sharedPreference.edit().putBoolean(IS_WELCOME_SCREEN_SHOWN, true).apply()
                    }
                }
            }
        }
    }

    private fun provideStartDestination(): String {
        return if (sharedPreference.getBoolean(IS_WELCOME_SCREEN_SHOWN, false)) {
            Screen.HomeScreen.route
        } else {
            Screen.WelcomeScreen.route
        }
    }
}
