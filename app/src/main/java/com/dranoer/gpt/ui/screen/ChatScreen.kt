package com.dranoer.gpt.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dranoer.gpt.ui.theme.GptTheme

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {

    Surface(modifier = modifier.fillMaxSize()) {
        Text(text = "chat screen")
    }
}

//region Preview
@Preview("Normal detail screen")
@Composable
private fun ChatPreview_Normal() {
    GptTheme {
        ChatScreen()
    }
}
//endregion