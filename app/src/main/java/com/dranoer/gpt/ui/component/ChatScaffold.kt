package com.dranoer.gpt.ui.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dranoer.gpt.R
import com.dranoer.gpt.ui.theme.GptTheme

@Composable
fun ChatScaffold(
    title: String = "GPTPlus",
    userInputPromptText: String = "",
    content: @Composable (() -> Unit)? = null,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(modifier = Modifier.padding(all = 2.dp)) {
                        Text(text = title, fontSize = 16.sp)
                        Text(text = "online", fontSize = 10.sp)
                    }

                }
            )
        },
        bottomBar = {
            ChatTextFieldBottomBar(
                currentPromptText = userInputPromptText,
                onSubmitButtonClicked = {},
                onPromptChanged = {}
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = Color.LightGray
        ) {
            content?.invoke()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ChatTextFieldBottomBar(
    currentPromptText: String,
    onSubmitButtonClicked: (() -> Unit)? = null,
    onPromptChanged: ((String) -> Unit)? = null
) = Card(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
    elevation = CardDefaults.cardElevation(8.dp),
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(
        containerColor = Color(
            if (isSystemInDarkTheme()) 0xFF414148 else 0xFFFFFFFF
        )
    )
) {

//    val keyboardManager = LocalSoftwareKeyboardController.current

    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = currentPromptText,
            onValueChange = { onPromptChanged?.invoke(it) },
            label = { androidx.compose.material3.Text(stringResource(R.string.app_name)) },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
        )
        Spacer(modifier = Modifier.width(8.dp))
        ElevatedButton(
            onClick = {
//                onSubmitButtonClicked?.invoke()
//                keyboardManager?.hide()
            }
        ) {
            androidx.compose.material3.Text(text = stringResource(R.string.submit), modifier = Modifier.padding(4.dp))
        }
    }
}

//region Preview
@Preview("Normal detail screen")
@Composable
private fun ChatPreview_Normal() {
    GptTheme {
        ChatScaffold()
    }
}
//endregion