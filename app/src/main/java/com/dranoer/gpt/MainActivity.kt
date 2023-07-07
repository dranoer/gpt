package com.dranoer.gpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dranoer.gpt.ui.screen.ChatScreen
import com.dranoer.gpt.ui.theme.GptTheme
import com.dranoer.gpt.ui.util.Route.Chat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GptTheme() {
                AppScreen()
            }
        }
    }
}

@Composable
private fun AppScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Chat.path,
    ) {
        //region Chat Screen
        composable(route = Chat.path) {
            ChatScreen()
        }//endregion
    }
}

//region Preview
@Preview(showBackground = true)
@Composable
private fun AppPreview() {
    GptTheme() {
        AppScreen()
    }
}
//endregion