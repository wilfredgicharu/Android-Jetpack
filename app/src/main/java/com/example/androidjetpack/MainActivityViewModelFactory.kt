package com.example.androidjetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//this is the factory class
//and it doesnt have any constructor
//it has a create method
class MainActivityViewModelFactory(private val startingTitle: String, private val startingResult: Int)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(startingTitle, startingResult) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
