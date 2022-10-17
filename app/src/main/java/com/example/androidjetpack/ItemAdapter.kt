package com.example.androidjetpack

import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: ArrayList<EmployeeEntity>,
                  private val updateListener:(id:Int)->Unit,
                  private val deleteListener:(id:Int)->Unit) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    }