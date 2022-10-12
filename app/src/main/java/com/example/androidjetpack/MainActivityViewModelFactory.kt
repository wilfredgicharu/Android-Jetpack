package com.example.androidjetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.volley.RequestQueue

//this is the factory class
//and it doesnt have any constructor
//it has a create method
class MainActivityViewModelFactory(var mRequestQueue: RequestQueue)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(mRequestQueue) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
