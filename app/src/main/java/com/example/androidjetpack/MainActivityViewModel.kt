package com.example.androidjetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue

class MainActivityViewModel(var mRequestQueue: RequestQueue): ViewModel() {
    var localPosts = MutableLiveData<ArrayList<Post>>()
    var onlinePosts = MutableLiveData<ArrayList<Post>>()
    var mainRepository = MainRepository(mRequestQueue)

    init {
        localPosts.value = MainRepository(mRequestQueue).getData() //get data from local
        MainRepository(mRequestQueue).fetchOnlineData() //get data from online
        onlinePosts = mainRepository.posts
    }

    //Notes
    //LiveData is an observable data holder class
    //LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services
    //RequestQueue is a class that handles asynchronous HTTP requests on Volley
    //MutableLiveData is a subclass of LiveData


}