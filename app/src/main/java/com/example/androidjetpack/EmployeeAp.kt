package com.example.androidjetpack

import android.app.Application

class EmployeeAp: Application() {
    val db by lazy {
        EmployeeDatabase.getInstance(this)
    }
}