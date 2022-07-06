package com.dynast.calendar.presentation.main.state

import com.dynast.calendar.domain.model.card.UserData


data class EditUiState(
    // 제목
    val title: String? = null,
    // 날짜
    val date: DateAndTimeZone = DateAndTimeZone(
        startDate = 1656511200,
        endDate = 1656511200 + 86400,
        allDay = true
    ),
    // 사용자
    val user: MutableList<UserData>? = null,
    // 화상회의
    var meet: Boolean = false,
    // 위치
    val location: Any? = null,
    // 알림
    val alarms: MutableList<Any>? = null,
    // 색상
    var color: Int = 11,
    // 설명
    val explanation: String? = null,
    // 첨부파일
    val attachFile: Any? = null
) {
    companion object {
        val TAG: String = EditUiState::class.java.simpleName
    }

}


//EST - -05:00
//HST - -10:00
//MST - -07:00
//ACT - Australia/Darwin
//AET - Australia/Sydney
//AGT - America/Argentina/Buenos_Aires
//ART - Africa/Cairo
//AST - America/Anchorage
//BET - America/Sao_Paulo
//BST - Asia/Dhaka
//CAT - Africa/Harare
//CNT - America/St_Johns
//CST - America/Chicago
//CTT - Asia/Shanghai
//EAT - Africa/Addis_Ababa
//ECT - Europe/Paris
//IET - America/Indiana/Indianapolis
//IST - Asia/Kolkata
//JST - Asia/Tokyo
//MIT - Pacific/Apia
//NET - Asia/Yerevan
//NST - Pacific/Auckland
//PLT - Asia/Karachi
//PNT - America/Phoenix
//PRT - America/Puerto_Rico
//PST - America/Los_Angeles
//SST - Pacific/Guadalcanal
//VST - Asia/Ho_Chi_Minh