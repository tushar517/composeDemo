package com.example.coroutinechannel.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.coroutinechannel.navigation.DetailPage
import com.example.coroutinechannel.navigation.SearchResult
import com.example.coroutinechannel.navigation.UserDetail
import com.example.coroutinechannel.ui.components.CustomButton
import com.example.coroutinechannel.ui.components.CustomTextField
import com.example.coroutinechannel.ui.theme.grey_CD
import com.example.coroutinechannel.ui.theme.typography
import com.example.coroutinechannel.viewModel.home.HomeEvent
import com.example.coroutinechannel.viewModel.home.HomeState

@Composable
fun MainScreen(
    data: HomeState,
    onEvent: (HomeEvent) -> Unit = { },
    homeNavController: NavHostController,
    userDetail: UserDetail,
    mainNavController: NavHostController
) {
    var employeeCode by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("userName: ${userDetail.userName}", style = typography.bodyLarge)
        Spacer(
            Modifier
                .height(20.dp)
        )
        Text("password: ${userDetail.password}", style = typography.bodyLarge, modifier = Modifier.clickable{
            mainNavController.navigate(SearchResult(""))
        })
        CustomTextField(
            label = "Employee Code",
            value = employeeCode,
            keyBoardType = KeyboardType.Text,
            onValueChange = { value ->
                employeeCode = value
            },
            modifier = Modifier.padding(top = 50.dp)
        )
        mainNavController.currentBackStackEntry?.savedStateHandle?.get<String>("query")
            ?.let { searchQuery ->
                Spacer(
                    Modifier
                        .height(20.dp)
                )
                Text(
                    "password: ${searchQuery}", style = typography.bodyMedium.copy(
                        color = grey_CD
                    )
                )
            }
        CustomButton(
            text = "Get Code",
            onClick = {
                homeNavController.navigate(DetailPage)
            },
            modifier = Modifier.padding(top = 30.dp),
            isEnable = true
        )
    }
}
