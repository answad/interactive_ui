package com.itismy.interactive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.itismy.interactive.screen.HomeScreen
import com.itismy.interactive.ui.theme.InteractiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            InteractiveTheme {
                HomeScreen()
            }
        }
    }
}