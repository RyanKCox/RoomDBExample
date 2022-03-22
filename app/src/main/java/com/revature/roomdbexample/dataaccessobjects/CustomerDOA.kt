package com.revature.roomdbexample.dataaccessobjects

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.revature.roomdbexample.datamodels.Customer

@Dao
interface CustomerDOA {

    @Query("SELECT * FROM customer")
    fun fetchAllCustomers():LiveData<List<Customer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer)

    @Query("DELETE FROM customer where id=:id")
    suspend fun deleteCustomerById(id: Int)
}