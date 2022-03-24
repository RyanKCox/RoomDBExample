package com.revature.roomdbexample.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.revature.roomdbexample.CustomerViewModel
import com.revature.roomdbexample.datamodels.Customer

@Composable
fun UpdateCustomer(navController: NavController, customerViewModel: CustomerViewModel) {

    var sName by rememberSaveable { mutableStateOf("") }
    var sGender by rememberSaveable { mutableStateOf("") }
    var sEmail by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopAppBar(title = { Text("UpdateCustomer") })

        DisplayCustomer(navController, customerViewModel, customerViewModel.focusCustomer!!)

        Spacer(modifier = Modifier.size(10.dp))

        TextField(value = sName,
            onValueChange = { sName = it },
            modifier = Modifier.fillMaxWidth(.7f),
            textStyle = MaterialTheme.typography.body1,
            label = { Text("Change Name:") },
            placeholder = { Text( customerViewModel.focusCustomer!!.name!!)})

        Spacer(modifier = Modifier.size(10.dp))

        TextField(value = sGender,
            onValueChange = { sGender = it },
            modifier = Modifier.fillMaxWidth(.7f),
            textStyle = MaterialTheme.typography.body1,
            label = { Text("Change Gender:") },
            placeholder = { Text( customerViewModel.focusCustomer!!.gender!!)})

        Spacer(modifier = Modifier.size(10.dp))

        TextField(value = sEmail,
            onValueChange = { sEmail = it },
            modifier = Modifier.fillMaxWidth(.7f),
            textStyle = MaterialTheme.typography.body1,
            label = { Text("Change Email:")},
            placeholder = { Text( customerViewModel.focusCustomer!!.email!!)})

        Spacer(modifier = Modifier.size(10.dp))

        Button(
            onClick = {

                //if nothing was changed, keep original
                if (sName == "") sName = customerViewModel.focusCustomer!!.name!!
                if (sGender == "") sGender = customerViewModel.focusCustomer!!.gender!!
                if (sEmail == "") sEmail = customerViewModel.focusCustomer!!.email!!

                //update customer
                customerViewModel.updateCustomer(
                    id = customerViewModel.focusCustomer!!.id,
                    sName = sName, sGender = sGender, sEmail = sEmail)
                navController.popBackStack()},
            Modifier
                .fillMaxWidth(.5f)
                .height(60.dp)
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
        ) {
            Text(text = "Update Customer")


        }
    }
}