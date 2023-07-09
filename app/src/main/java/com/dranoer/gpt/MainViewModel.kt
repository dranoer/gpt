package com.dranoer.gpt

import androidx.lifecycle.ViewModel
import com.dranoer.networking.model.ChatModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {


    sealed class ChatUIState {
        object Loading: ChatUIState()
        data class Success(val data: MutableList<ChatModel>): ChatUIState()
        data class Error(val message: String): ChatUIState()
    }
}