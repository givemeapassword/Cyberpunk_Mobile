package com.example.rp_cyberpunk_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {
    private val _textData = MutableLiveData<String>()
    private val _classData = MutableLiveData<String>()
    val textData: LiveData<String>
        get() = _textData
    val classData: LiveData<String>
        get() = _classData

    fun setTextData(text: String) {
        _textData.value = text
    }
    fun setClassData(text: String){
        _classData.value = text
    }
}