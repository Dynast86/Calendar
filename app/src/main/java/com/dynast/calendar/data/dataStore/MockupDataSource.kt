package com.dynast.calendar.data.dataStore

import com.dynast.calendar.data.ApiService
import com.dynast.calendar.data.dto.CardModel
import javax.inject.Inject

class MockupDataSource @Inject constructor(
    private val api: ApiService
) {
    val cards: List<CardModel> = getMockup()

    private fun getMockup(): List<CardModel> {
        val items = mutableListOf<CardModel>()
        repeat(100) {
            items.add(
                CardModel(title = "Preview $it", content = "테스트 | 총 ${it}강")
            )
        }
        return items.toList()
    }
}