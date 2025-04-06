package com.example.assignment2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController, viewModel: EmployeeViewModel) {
    val employees = viewModel.employeeList

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Employee Details", fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.background(color = Color.Transparent)) }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(employees) { employee ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp, shape = MaterialTheme.shapes.medium)
                        .clickable {
                            navController.navigate("detail/${employee.name}/${employee.age}/${employee.salary}")
                        },
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F3F4)),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.AccountCircle, contentDescription = null, tint = Color(0xFF4285F4))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = employee.name, fontSize = 20.sp, color = Color.Black)
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.DateRange, contentDescription = null, tint = Color(0xFF34A853))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Age: ${employee.age}", fontSize = 16.sp)
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.AccountBox, contentDescription = null, tint = Color(0xFFFBBC05))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Salary: ₹${employee.salary}", fontSize = 16.sp, color = Color.DarkGray)
                        }
                    }
                }
            }
        }
    }
}
