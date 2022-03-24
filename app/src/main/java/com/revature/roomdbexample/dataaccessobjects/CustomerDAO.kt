package com.revature.roomdbexample.dataaccessobjects

import androidx.lifecycle.LiveData
import androidx.room.*
import com.revature.roomdbexample.datamodels.Customer

@Dao
interface CustomerDAO {

    @Query("SELECT * FROM customer")
    fun fetchAllCustomers():LiveData<List<Customer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer)

    @Query("DELETE FROM customer WHERE id=:id")
    suspend fun deleteCustomerById(id: Int)

    @Query("UPDATE customer SET name = :sName WHERE id= :id")
    suspend fun updateCustomerNameById(id:Int, sName:String)

    @Query("UPDATE customer SET gender = :sGender WHERE id= :id")
    suspend fun updateCustomerGenderById(id:Int, sGender:String)

    @Query("UPDATE customer SET email = :sEmail WHERE id= :id")
    suspend fun updateCustomerEmailById(id:Int, sEmail:String)
}