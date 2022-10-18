package com.example.androidjetpack

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.*
import com.example.androidjetpack.databinding.ActivityMainBinding
import com.google.android.material.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import java.nio.file.attribute.AclEntry.Builder


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }




}