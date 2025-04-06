package com.example.assignment2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(name: String, age: Int, salary: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Employee Details") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Name: $name", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Age: $age", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Salary: ₹$salary", fontSize = 18.sp)
        }
    }
}
