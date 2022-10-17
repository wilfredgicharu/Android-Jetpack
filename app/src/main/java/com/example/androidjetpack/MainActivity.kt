package com.example.androidjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.androidjetpack.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val employeeDao = (application as EmployeeAp).db.employeeDao()
        binding.btnAdd.setOnClickListener {
            addRecord(employeeDao)
        }

        lifecycleScope.launch {
            employeeDao.fetchAllEmployee().collect {
                val list = ArrayList(it)
                setupListOfDataIntoRecyclerView(list,employeeDao)
            }
        }
    }



    private fun setupListOfDataIntoRecyclerView(employeeList: Any, employeeDao: EmployeeDao) {

    }


    private fun addRecord(employeeDao: EmployeeDao) {

    }
}