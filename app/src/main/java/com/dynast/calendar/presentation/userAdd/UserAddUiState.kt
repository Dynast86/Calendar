package com.dynast.calendar.presentation.userAdd

import androidx.compose.runtime.mutableStateListOf
import com.dynast.calendar.domain.model.card.UserData

class UserAddUiState(
    initialUsers: List<UserData>
) {
    private val _users: MutableList<UserData> = mutableStateListOf(*initialUsers.toTypedArray())
//    val users: List<UserData> = _users

    private val _addUsers: MutableList<UserData> = mutableStateListOf()
    val addUsers: List<UserData> get() = _addUsers

    private val _filteredUsers: MutableList<UserData> = mutableStateListOf()
    val filteredUsers: List<UserData> get() = _filteredUsers

    fun addUsers(msg: UserData) {
        _addUsers.add(msg)
    }

    fun deleteUsers(msg: UserData) {
        _addUsers.remove(msg)
    }

    fun filteredUsers(text: String) = with(_filteredUsers) {
        clear()
        addAll(_users.filter { it.name.contains(text) })
    }
}