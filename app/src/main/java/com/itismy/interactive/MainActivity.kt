package com.itismy.interactive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.itismy.interactive.screen.HomeScreen
import com.itismy.interactive.screen.ScrollScreen
import com.itismy.interactive.ui.theme.InteractiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            InteractiveTheme {
                Scaffold {
                    InteractiveNavHost(
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }
}

@Composable
fun InteractiveNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "home",
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(
            "home",
            exitTransition = { fadeOut(animationSpec = tween(durationMillis = 1000)) },
            enterTransition = { scaleIn(animationSpec = tween(durationMillis = 1000)) },
        ) {
            HomeScreen(
                navigateToScroll = { navController.navigate("scroll") },
            )
        }
        composable(
            "scroll",
            enterTransition = { scaleIn(animationSpec = tween(durationMillis = 1000)) },
            exitTransition = { fadeOut(animationSpec = tween(durationMillis = 1000)) },
        ) {
            ScrollScreen()
        }
    }
}