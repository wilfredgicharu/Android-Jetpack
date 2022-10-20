package com.example.androidjetpack.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.androidjetpack.MainActivity
import com.example.androidjetpack.Model.Note
import com.example.androidjetpack.R
import com.example.androidjetpack.ViewModel.NoteViewModel
import com.example.androidjetpack.databinding.ActivityAnotherBinding
import java.util.*
import kotlin.properties.Delegates

class AnotherActivity : AppCompatActivity() {
    private lateinit var getData: String
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var date: Date
    private var getCharacter by Delegates.notNull<Long>()
    private lateinit var getDate: String
    private lateinit var binding: ActivityAnotherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAnotherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar1)
        noteViewModel = NoteViewModel()
        val upArrow = resources.getDrawable(R.drawable.arrow)
        getDate()

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
            setHomeAsUpIndicator(upArrow)
        }
        binding.toolbar1.setNavigationOnClickListener {
            backToHomePage()
        }
        binding.note.addTextChangedListener(textWatcher)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.another_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when (item.itemId) {
            R.id.save -> {
                saveDataIntoDatabase()
                if (getData.isNotEmpty()){
                    noteViewModel.insert(applicationContext, Note(getData, getDate, getCharacter))
                    backToHomePage()
                }
                else{
                    Toast.makeText(applicationContext, "Please write something", Toast.LENGTH_SHORT).show()
                }

            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveDataIntoDatabase() {
        getData = binding.note.text.toString()
        getDate = binding.currentDate.text.toString()
        getCharacter = getData.trim().length.toLong()
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.characters.text = " | Characters " + s?.length.toString()
        }
    }

    private fun backToHomePage() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun getDate() {
        date =Calendar.getInstance().time
        binding.currentDate.text = date.toString()
    }
}