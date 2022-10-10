package com.example.androidjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidjetpack.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModelFactory = MainActivityViewModelFactory("counter Result", 0)
        val viewModel: MainActivityViewModel =
            ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        viewModel.readTitle.observe(this, Observer {
            binding.textTitle.text = it.toString()
        })
        viewModel.readResult.observe(this, Observer {
            binding.textResult.text = it.toString()
        })

        binding.apply {
            buttonPlus.setOnClickListener {
                viewModel.setPlus(editInput.text.toString().toInt())
            }
            buttonMinus.setOnClickListener {
                viewModel.setMinus(editInput.text.toString().toInt())
            }
            buttonTimes.setOnClickListener {
                viewModel.setTime(editInput.text.toString().toInt())
            }
            buttonDivide.setOnClickListener {
                viewModel.setDivide(editInput.text.toString().toInt())
            }
        }
    }

}