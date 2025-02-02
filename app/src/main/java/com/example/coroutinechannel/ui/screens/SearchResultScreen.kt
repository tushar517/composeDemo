package com.example.coroutinechannel.ui.screens

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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.coroutinechannel.navigation.SearchModel
import com.example.coroutinechannel.ui.components.CustomButton
import com.example.coroutinechannel.ui.components.CustomTextField
import com.example.coroutinechannel.ui.theme.typography

@Composable
fun SearchResultScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var search by remember {
            mutableStateOf("")
        }
        CustomTextField(
            label = "Employee Code",
            value = search,
            keyBoardType = KeyboardType.Text,
            onValueChange = { value ->
                search = value
            },
            modifier = Modifier.padding(top = 50.dp)
        )
        Spacer(Modifier
            .height(20.dp))
        CustomButton(
            text = "Get Code",
            onClick = {
                navHostController.previousBackStackEntry?.savedStateHandle?.set("query",search)
                navHostController.popBackStack()
            },
            modifier = Modifier.padding(top = 30.dp),
            isEnable = true
        )
    }
}