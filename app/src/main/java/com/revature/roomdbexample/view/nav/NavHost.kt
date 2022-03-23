package com.revature.roomdbexample.view.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.revature.roomdbexample.CustomerViewModel
import com.revature.roomdbexample.view.AddCustomerScreen

@Composable
fun startNav(customerViewModel: CustomerViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = Screens.AddCustomerScreen.route){

        composable(Screens.AddCustomerScreen.route){
            AddCustomerScreen(navController, customerViewModel)
        }
    }
}