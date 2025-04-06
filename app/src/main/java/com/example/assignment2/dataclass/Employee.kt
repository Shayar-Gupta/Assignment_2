package com.example.assignment2.dataclass

data class EmployeeResponse(
    val employees: List<Employee>
)

data class Employee(
    val name: String,
    val age: Int,
    val salary: Int
)
