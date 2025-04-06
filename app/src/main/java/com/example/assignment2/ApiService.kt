package com.example.assignment2

import com.example.assignment2.dataclass.EmployeeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("dummy/EmployeeDetails.json")
    suspend fun getEmployees(): EmployeeResponse
}