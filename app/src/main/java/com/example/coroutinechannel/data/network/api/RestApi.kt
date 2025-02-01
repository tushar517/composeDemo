package com.example.coroutinechannel.data.network.api

import com.example.coroutinechannel.data.model.LoginRequest
import com.example.coroutinechannel.data.model.LoginResponse
import com.example.coroutinechannel.data.model.CommonResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RestApi {
    @POST("mdm/loginUser")
    suspend fun callLoginApi(@Body commonRequest: LoginRequest): CommonResponse<LoginResponse>
}