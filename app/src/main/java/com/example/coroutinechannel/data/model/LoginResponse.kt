package com.example.coroutinechannel.data.model

data class LoginResponse(
    val AUTH_TOKEN: String,
    val contact_no: String,
    val customer_code: String,
    val department_code: String,
    val description: String,
    val first_name: String,
    val group_code: String,
    val last_login: String,
    val last_name: String,
    val location_code: String,
    val service_center_type: String,
    val status_code: Int,
    val user_name: String
)