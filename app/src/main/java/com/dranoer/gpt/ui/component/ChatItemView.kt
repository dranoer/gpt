package com.dranoer.gpt.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dranoer.gpt.ui.theme.GptTheme
import com.dranoer.networking.model.ChatModel
import com.dranoer.networking.model.UserType

@Composable
fun ChatItemView(model: ChatModel) {

    Box(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .wrapContentWidth()
                .align(
                    when (model.type) {
                        UserType.USER -> Alignment.CenterEnd
                        UserType.GPT -> Alignment.CenterStart
                    }
                ),
            shape = RoundedCornerShape(10.dp),
            elevation = 2.dp,
            backgroundColor = when (model.type) {
                UserType.USER -> Color.Blue
                UserType.GPT -> Color.Green
            },
            contentColor = when (model.type) {
                UserType.USER -> Color.Black
                UserType.GPT -> Color.Black
            },
        ) {
            //region Prompt
            model.text?.let {
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentWidth(),
                    text = it,
                    fontSize = 12.sp,
                )
            }
            //endregion
        }
    }
}

//region Preview
@Preview
@Composable
fun ChatItemPreview_Normal() {
    GptTheme {
        ChatItemView(
            model = ChatModel(
                text = "how can i help you?",
                type = UserType.GPT
            )
        )
    }
}

@Preview
@Composable
fun ChatItemPreview_LongText() {
    GptTheme {
        ChatItemView(
            model = ChatModel(
                text = "how can i help you? how can i help you? how can i help you? how can i help you? how can i help you? how can i help you? how can i help you?",
                type = UserType.GPT
            )
        )
    }
}
//endregion