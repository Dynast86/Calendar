package com.dynast.calendar.ui.alarm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlarmViewModel @Inject constructor(

) : ViewModel() {
    companion object {
        val TAG: String = AlarmViewModel::class.java.simpleName
    }
}