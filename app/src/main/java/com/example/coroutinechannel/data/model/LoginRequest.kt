package com.example.coroutinechannel.data.model

data class LoginRequest(
    val device_info: DeviceInfo,
    val password: String,
    val username: String
)