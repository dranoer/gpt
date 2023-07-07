package com.dranoer.gpt.ui.util

import com.dranoer.gpt.ui.util.Const.CHAT_SCREEN

sealed class Route(val path: String) {
    object Chat : Route(path = CHAT_SCREEN)
}