package com.dranoer.gpt.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dranoer.gpt.ui.component.ChatListLazyColumn
import com.dranoer.gpt.ui.component.ChatScaffold
import com.dranoer.gpt.ui.theme.GptTheme
import com.dranoer.networking.model.ChatModel
import com.dranoer.networking.model.UserType

@Composable
fun ChatScreen() {

    ChatScreenScaffold()
}

@Composable
fun ChatScreenScaffold() {
    ChatScaffold(
        title = "GPTPlus",
        userInputPromptText = "user said something..",
    ) {
        ChatListLazyColumn(
            chatList = listOf(
                ChatModel(
                    text = "11111111111111111111111111111111111111",
                    type = UserType.GPT
                ),
                ChatModel(
                    text = "Helloooo",
                    type = UserType.USER
                ),
                ChatModel(
                    text = "how can i help you?",
                    type = UserType.GPT
                ),
                ChatModel(
                    text = "thius how thius how thius how thius how thius how thius how thius how thius how thius how thius how thius how thius how thius how thius how thius how ",
                    type = UserType.USER
                ),
                ChatModel(
                    text = "thius how thius how thius how ",
                    type = UserType.GPT
                )
            )
        )
    }
}

//region Preview
@Preview
@Composable
private fun ChatScreenPreview_Normal() {
    GptTheme {
        ChatScreen()
    }
}
//endregion