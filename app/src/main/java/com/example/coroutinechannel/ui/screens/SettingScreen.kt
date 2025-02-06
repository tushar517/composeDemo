package com.example.coroutinechannel.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.coroutinechannel.navigation.ProfilePage
import com.example.coroutinechannel.navigation.UserDetail
import com.example.coroutinechannel.ui.components.ListItem

@Composable
fun SettingScreen(userDetail: UserDetail, settingNavController: NavHostController) {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        ListItem(userDetail.userName, userDetail.password) {
            settingNavController.navigate(
                ProfilePage
            )
        }
    }

}