package com.dranoer.gpt.networking.mapper

import com.dranoer.gpt.networking.model.DetailItem
import com.dranoer.gpt.networking.model.DetailResponse

class DetailMapper {
    fun map(response: DetailResponse): DetailItem {
        return response.artDetail.let { item ->
            DetailItem(
                id = item.id,
                artist = item.artist ?: "",
                title = item.title ?: "",
                description = item.description ?: "",
                imageUrl = item.image?.url ?: "",
            )
        }
    }
}