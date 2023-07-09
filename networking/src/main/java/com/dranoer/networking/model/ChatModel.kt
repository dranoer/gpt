package com.dranoer.networking.model

data class ChatModel(
    val text: String? = "static text",
    val type: UserType,
)

enum class UserType {
    GPT, USER
}