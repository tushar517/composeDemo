package com.example.coroutinechannel.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coroutinechannel.R
import com.example.coroutinechannel.data.model.ApiResult
import com.example.coroutinechannel.navigation.Home
import com.example.coroutinechannel.navigation.UserDetail
import com.example.coroutinechannel.ui.components.CustomButton
import com.example.coroutinechannel.ui.components.CustomLoader
import com.example.coroutinechannel.ui.components.CustomTextField
import com.example.coroutinechannel.ui.components.PermissionHandler
import com.example.coroutinechannel.ui.theme.typography
import com.example.coroutinechannel.ui.theme.blue_F8
import com.example.coroutinechannel.ui.theme.white
import com.example.coroutinechannel.viewModel.login.LoginEvent
import com.example.coroutinechannel.viewModel.login.LoginState

@Composable
fun LoginScreen(data: LoginState, onEvent: (LoginEvent) -> Unit, navController: NavController) {
    val context = LocalContext.current
    var employeeCode by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPassword by remember {
        mutableStateOf(true)
    }
    val isButtonEnable = remember {
        derivedStateOf {
            employeeCode.isNotBlank() && password.isNotBlank()
        }
    }
    LaunchedEffect(data.loginApiResult) {
        data.loginApiResult.let { response ->
            when (response) {
                is ApiResult.Success -> {
                    navController.navigate(Home(UserDetail(userName = employeeCode, password = password)))
                    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                }

                is ApiResult.Error -> {
                    Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                }

                else -> {}
            }
        }
    }

    Scaffold {

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = white)
                .padding(top = 50.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "logo",

                )
            CustomTextField(
                label = "Employee Code",
                value = employeeCode,
                keyBoardType = KeyboardType.Text,
                onValueChange = { value ->
                    employeeCode = value
                },
                modifier = Modifier.padding(top = 50.dp)
            )
            CustomTextField(
                value = password,
                onValueChange = { value ->
                    password = value
                },
                label = "Password",
                keyBoardType = KeyboardType.Password,
                modifier = Modifier.padding(top = 30.dp),
                visualTransformation = if (isPassword) VisualTransformation { value ->
                    TransformedText(
                        AnnotatedString("*".repeat(value.length)),
                        OffsetMapping.Identity
                    )
                } else {
                    VisualTransformation.None
                },
                icon = {
                    IconButton(
                        onClick = { isPassword = !isPassword },
                        modifier = Modifier.padding(0.dp)
                    ) {
                        if (isPassword) {
                            Image(
                                painter = painterResource(R.drawable.ic_password_off),
                                contentDescription = "",
                            )
                        } else {
                            Image(
                                painter = painterResource(R.drawable.ic_password_on),
                                contentDescription = ""
                            )
                        }
                    }
                }
            )
            Text(
                text = "Forgot Password?",
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.End),
                style = typography.bodySmall.copy(
                    color = blue_F8,
                )
            )
            CustomButton(
                text = "Get Code",
                onClick = {
                    /*onEvent(
                        LoginEvent.LoginApiCall(
                            username = employeeCode,
                            password = password,
                            lat = 28.5022445,
                            long = 77.0986009
                        )
                    )*/
                    navController.navigate(Home(UserDetail(userName = employeeCode, password = password)))


                },
                modifier = Modifier.padding(top = 30.dp),
                isEnable = isButtonEnable.value
            )
        }
        if (data.isLoading) {
            CustomLoader()
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        data = LoginState(),
        onEvent = {},
        rememberNavController()
    )

}