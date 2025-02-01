package com.example.coroutinechannel.viewModel.login

sealed interface LoginEvent {
    data class LoginApiCall(val username: String, val password: String,val lat:Double,val long:Double) : LoginEvent
}