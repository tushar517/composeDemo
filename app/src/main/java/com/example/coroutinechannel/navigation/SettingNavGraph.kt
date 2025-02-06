package com.example.coroutinechannel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coroutinechannel.ui.screens.ProfileScreen
import com.example.coroutinechannel.ui.screens.SettingScreen

@Composable
fun SettingNavGraph(
    settingNavController: NavHostController,
    userDetail: UserDetail,
    mainNavController: NavHostController
) {
    NavHost(
        settingNavController,
        startDestination = SettingPage
    ) {

        composable<SettingPage>{
            SettingScreen(
                userDetail,
                settingNavController
            )
        }
        composable<ProfilePage>{
            ProfileScreen()
        }
    }
}