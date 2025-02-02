package com.example.coroutinechannel.viewModel.login

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinechannel.BuildConfig
import com.example.coroutinechannel.data.model.ApiResult
import com.example.coroutinechannel.data.model.DeviceInfo
import com.example.coroutinechannel.data.model.LoginRequest
import com.example.coroutinechannel.data.network.datasource.datastore.DataStoreHelper
import com.example.coroutinechannel.data.network.datasource.datastore.PreferenceKey
import com.example.coroutinechannel.data.network.datasource.remote.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val useCase: AuthUseCase,
    val dataStore: DataStoreHelper
):ViewModel() {
    private val loginState= MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> get() = loginState

    fun onEvent(event: LoginEvent){
        when(event){
            is LoginEvent.LoginApiCall -> {
                val loginRequest = LoginRequest(
                    username = event.username,
                    password = event.password,
                    device_info = DeviceInfo(
                        sdk_version_code = BuildConfig.VERSION_NAME,
                        manufacturer = Build.MANUFACTURER,
                        sdk_version = Build.VERSION.RELEASE,
                        model_number = Build.MODEL,
                        latitude = event.lat,
                        longitude = event.long
                    )
                )
                viewModelScope.launch {
                    loginState.value = loginState.value.copy(isLoading = true)

                    val response = useCase.callLogin(loginRequest)
                    try{
                        if (response.status) {
                            loginState.value = loginState.value.copy(
                                loginApiResult = ApiResult.Success(response),
                                isLoading = false
                            )
                            dataStore.setData(PreferenceKey.authToken,response.response.AUTH_TOKEN)
                        } else {
                            loginState.value = loginState.value.copy(
                                loginApiResult = ApiResult.Error(response.response.description),
                                isLoading = false
                            )
                        }
                    }catch (ex:Exception){
                        loginState.value = loginState.value.copy(
                            loginApiResult = ApiResult.Error(ex.message.toString()),
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

}