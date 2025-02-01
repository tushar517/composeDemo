package com.example.coroutinechannel.data.network.datasource.remote.repository

import com.example.coroutinechannel.data.model.CommonResponse
import com.example.coroutinechannel.data.model.LoginRequest
import com.example.coroutinechannel.data.model.LoginResponse
import com.example.coroutinechannel.data.network.api.RestApi

class RepositoryImpl(
    val restApi: RestApi
): Repository {
    override suspend fun userLogin(loginRequest: LoginRequest): CommonResponse<LoginResponse> {
        return restApi.callLoginApi(loginRequest)
    }
}