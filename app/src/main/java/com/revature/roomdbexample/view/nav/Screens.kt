package com.revature.roomdbexample.view.nav

sealed class Screens (val route:String) {

    object AddCustomerScreen:Screens("AddCustomerScreen")
}