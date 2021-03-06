package com.revature.roomdbexample.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.revature.roomdbexample.dataaccessobjects.CustomerDAO
import com.revature.roomdbexample.datamodels.AppDatabase
import com.revature.roomdbexample.datamodels.Customer

class CustomerRepository(application:Application) {

    private var customerDao:CustomerDAO

    init {
        var database = AppDatabase.getDatabase(application)
        customerDao = database.customerDao()
    }

    val readAllCustomers: LiveData<List<Customer>> =
        customerDao.fetchAllCustomers()

    suspend fun deleteCustomerById(id:Int){
        customerDao.deleteCustomerById(id)
    }

    suspend fun insertCustomer(customer:Customer){
        customerDao.insertCustomer(customer)
    }

    suspend fun updateCustomerById(id:Int, sName:String, sGender:String, sEmail:String){
        customerDao.updateCustomerNameById(id = id,sName = sName)
        customerDao.updateCustomerGenderById(id = id, sGender = sGender)
        customerDao.updateCustomerEmailById(id = id,sEmail = sEmail)
    }
}