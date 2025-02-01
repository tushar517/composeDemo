package com.example.coroutinechannel.data.network.datasource.remote.repository

import com.example.coroutinechannel.data.model.CommonResponse
import com.example.coroutinechannel.data.model.LoginRequest
import com.example.coroutinechannel.data.model.LoginResponse

interface Repository {

    suspend fun userLogin(loginRequest: LoginRequest): CommonResponse<LoginResponse>
}