package com.example.androidjetpack.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidjetpack.Model.Note
import com.example.androidjetpack.R
import com.example.androidjetpack.ViewModel.NoteViewModel
import com.example.androidjetpack.databinding.ActivityUpdateBinding
import java.util.Date

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var getNote: Note
    private lateinit var date: Date



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUpdateBinding.inflate(layoutInflater)

        setContentView(binding.root)


    }
}