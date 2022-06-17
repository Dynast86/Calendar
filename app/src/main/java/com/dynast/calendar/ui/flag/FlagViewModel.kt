package com.dynast.calendar.ui.flag

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FlagViewModel @Inject constructor(

) : ViewModel() {
    companion object {
        val TAG: String = FlagViewModel::class.java.simpleName
    }
}