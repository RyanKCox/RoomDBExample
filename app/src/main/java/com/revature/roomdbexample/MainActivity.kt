package com.revature.roomdbexample

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.revature.roomdbexample.datamodels.AppDatabase.Companion.getDatabase
import com.revature.roomdbexample.ui.theme.RoomDBExampleTheme
import com.revature.roomdbexample.view.nav.startNav

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Declare application level variables
        //val customerViewModel = CustomerViewModel(this.application)
        val customerViewModel = ViewModelProvider(this).get(
            CustomerViewModel::class.java)

        setContent {
            RoomDBExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    startNav(customerViewModel)
                }
            }
        }
    }
}
