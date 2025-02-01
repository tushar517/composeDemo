package com.example.coroutinechannel.data.network.datasource.remote.usecase

import com.example.coroutinechannel.data.model.CommonResponse
import com.example.coroutinechannel.data.model.LoginRequest
import com.example.coroutinechannel.data.model.LoginResponse
import com.example.coroutinechannel.data.network.datasource.remote.repository.Repository

class AuthUseCase(private val repository: Repository) {
    suspend fun callLogin(loginRequest: LoginRequest): CommonResponse<LoginResponse> {
        return repository.userLogin(loginRequest)
    }

}