package com.example.androidjetpack

import androidx.room.*

@Dao
interface EmployeeDao {
    @Insert
    suspend fun insert(employeeEntity: EmployeeEntity)

    @Update
    suspend fun update(employeeEntity: EmployeeEntity)

    @Delete
    suspend fun delete(employeeEntity: EmployeeEntity)

    @Query("Select * from `employee-table`")
    fun fetchAllEmployee():List<EmployeeEntity>

    @Query("Select * from `employee-table` where id=:id")
    fun fetchEmployeeById(id:Int):EmployeeEntity

}