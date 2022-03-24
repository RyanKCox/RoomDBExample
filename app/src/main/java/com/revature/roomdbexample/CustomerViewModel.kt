package com.revature.roomdbexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.roomdbexample.datamodels.Customer
import com.revature.roomdbexample.repository.CustomerRepository
import kotlinx.coroutines.launch

class CustomerViewModel(appObj: Application): AndroidViewModel(appObj) {

    private val customerRepository: CustomerRepository =
        CustomerRepository(appObj)
    var focusCustomer: Customer? = null

    fun fetchAllCustomers(): LiveData<List<Customer>> {
        return customerRepository.readAllCustomers
    }

    fun insertCustomer(customer: Customer){
        viewModelScope.launch {
            customerRepository.insertCustomer(customer)
        }
    }

    fun deleteCustomerById(id:Int){
        viewModelScope.launch {
            customerRepository.deleteCustomerById(id)
        }
    }

    fun updateCustomer(id:Int, sName:String, sGender:String, sEmail:String){
        viewModelScope.launch {
            customerRepository.updateCustomerById(id = id,
                sName = sName,
                sGender = sGender,
                sEmail = sEmail)
        }
    }
}