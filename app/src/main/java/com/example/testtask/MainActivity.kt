package com.example.testtask

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.rememberNavController
import com.example.testtask.navigation.Screen
import com.example.testtask.navigation.SetupNavGraph
import com.example.testtask.ui.theme.TestTaskTheme
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : ComponentActivity() {
    val firebaseAnalytics = FirebaseAnalytics.getInstance(this)
    private var currentScreen by mutableStateOf("")

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val params = Bundle().apply {
            putString(FirebaseAnalytics.Param.SCREEN_NAME, "App Launch")
            putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        }
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, params)
        setContent {
            val navController = rememberNavController()
            TestTaskTheme() {
                SetupNavGraph(navController = navController)
            }
            observeCurrentDestination(navController)
        }
    }

    private fun observeCurrentDestination(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->
            currentScreen = when (destination.route) {
                Screen.Test.route -> Screen.Test.route
                Screen.Web.route -> Screen.Web.route
                else -> ""
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val screenName: String
        val screenClass: String
        if (currentScreen == Screen.Test.route) {
            screenName = "TestScreen"
            screenClass = "MainActivity"
        } else {
            screenName = "WebViewPage"
            screenClass = "MainActivity"
        }
        val params = Bundle().apply {
            putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
            putString(FirebaseAnalytics.Param.SCREEN_CLASS, screenClass)
        }
        firebaseAnalytics.logEvent("screen_open", params)
    }
}