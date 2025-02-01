package com.example.coroutinechannel.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coroutinechannel.navigation.UserDetail
import com.example.coroutinechannel.ui.theme.typography
import com.example.coroutinechannel.viewModel.home.HomeEvent
import com.example.coroutinechannel.viewModel.home.HomeState

@Composable
fun HomeScreen(data: HomeState, onEvent: (HomeEvent) -> Unit = { }, userDetail: UserDetail) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("userName: ${userDetail.userName}",style = typography.bodyLarge)
        Spacer(
            Modifier
            .height(20.dp))
        Text("password: ${userDetail.password}", style = typography.bodyLarge)
    }
}