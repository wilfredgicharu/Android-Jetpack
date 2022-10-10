package com.example.androidjetpack

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var count = 0

    fun increment(){
        count++
    }
    fun decrement(){
        count--
    }
    fun add(){


    }
}