package com.example.androidjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.androidjetpack.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var MainActivityViewModelFactory: MainActivityViewModelFactory
    private lateinit var mRequestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mRequestQueue = Volley.newRequestQueue(this)
        MainActivityViewModelFactory = MainActivityViewModelFactory(mRequestQueue)

        mainActivityViewModel = ViewModelProvider(this, MainActivityViewModelFactory).get(MainActivityViewModel::class.java)

        binding.content.text = mainActivityViewModel.onlinePosts.value.toString()


        mainActivityViewModel.onlinePosts.observe(this, Observer {
            binding.content.text = it.toString()
        })


        }
    }