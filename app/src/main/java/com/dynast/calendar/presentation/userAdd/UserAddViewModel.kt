package com.dynast.calendar.presentation.userAdd

import androidx.lifecycle.ViewModel
import com.dynast.calendar.domain.model.card.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UserAddViewModel @Inject constructor(

) : ViewModel() {
    companion object {
        val TAG: String = UserAddViewModel::class.java.simpleName
    }

    private val users = listOf(
//        UserData(name = "김창구", email = "cgkim@eduwill.net"),
        UserData(name = "박소미", email = "smpark5@eduwill.net"),
        UserData(name = "송이", email = "ysong@eduwill.net"),
    )

    private val _userAddState = MutableStateFlow(UserAddUiState(initialUsers = users))
    val userAddState: StateFlow<UserAddUiState> get() = _userAddState

}