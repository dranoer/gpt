package com.dranoer.gpt.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dranoer.gpt.ui.theme.GptTheme
import com.dranoer.networking.model.ChatModel
import com.dranoer.networking.model.UserType

@Composable
fun ChatListLazyColumn(
    chatList: List<ChatModel>,
) {
    LazyColumn(
        modifier = Modifier.padding(all = 10.dp),
    ) {
        items(chatList) {
            ChatItemView(it)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

//region Preview
@Preview
@Composable
fun ChatListPreview_Normal() {
    GptTheme {
        ChatListLazyColumn(
            chatList = listOf(
                ChatModel(
                    text = "Hi",
                    type = UserType.GPT
                ),
                ChatModel(
                    text = "Hello",
                    type = UserType.USER
                ),
                ChatModel(
                    text = "how can i help you?",
                    type = UserType.GPT
                ),
                ChatModel(
                    text = "This is a very very very very long text question",
                    type = UserType.USER
                ),
                ChatModel(
                    text = "What?",
                    type = UserType.GPT
                )
            )
        )
    }
}
//endregion