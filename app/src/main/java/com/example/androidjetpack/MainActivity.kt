package com.example.androidjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val viewModel: MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.button.setOnClickListener{
            viewModel.increment()
            binding.textView.text = viewModel.count.toString()
        }
        binding.buttonDescrement.setOnClickListener{
            viewModel.decrement()
            binding.textView.text = viewModel.count.toString()
        }

        binding.equals.setOnClickListener{
            viewModel.add()
            addit()

        }



    }
    fun addit(){
        val viewModel: MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
       viewModel.add()
        val num1 = binding.number1.text.toString().trim()
        val num2 = binding.number2.text.toString().trim()
        //adding two numbers
        val sum = num1.toInt() + num2.toInt()
        binding.summation.text = sum.toString()
    }

}