package com.example.assignment2

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2.dataclass.Employee
import kotlinx.coroutines.launch

class EmployeeViewModel : ViewModel() {
    var employeeList by mutableStateOf<List<Employee>>(emptyList())

    init {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getEmployees()
                employeeList = response.employees
            } catch (e: Exception) {
                Log.e("EmployeeViewModel", "Error fetching employees", e)
            }
        }
    }
}
