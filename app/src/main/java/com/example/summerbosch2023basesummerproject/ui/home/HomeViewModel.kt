package com.example.summerbosch2023basesummerproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Summer@Bosch"
    }
    val text: LiveData<String> = _text
}