package com.example.coroutinechannel.viewModel.login

import com.example.coroutinechannel.data.model.ApiResult
import com.example.coroutinechannel.data.model.LoginResponse

data class LoginState(
    var isLoading:Boolean = false,
    var loginApiResult: ApiResult<LoginResponse> = ApiResult.Empty()
)
