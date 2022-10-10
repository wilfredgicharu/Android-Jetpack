package com.example.androidjetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTitle: String, startingResult: Int): ViewModel() {

    private var title = MutableLiveData<String>()
    private var result = MutableLiveData<Int>()

    val readTitle: LiveData<String> get() = title
    val readResult: LiveData<Int> get() = result

    init {
        title.value = startingTitle
        result.value = startingResult
    }

    fun setPlus(input: Int){
        result.value = result.value?.plus(input)
    }
    fun setMinus(input: Int){
        result.value = result.value?.minus(input)
    }

    fun setTime(input: Int){
        result.value = result.value?.times(input)
    }
    fun setDivide(input: Int){
        result.value = result.value?.div(input)
    }

//    var count = 0
//
//    fun increment(){
//        count++
//    }
//    fun decrement(){
//        count--
//    }
//    fun add(){
//    }
//
}