package com.dynast.calendar.presentation.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(

) : ViewModel() {
    companion object {
        val TAG: String = DetailViewModel::class.java.simpleName
    }
}