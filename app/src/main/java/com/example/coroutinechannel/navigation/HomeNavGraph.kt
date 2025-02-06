package com.example.coroutinechannel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coroutinechannel.ui.screens.DetailScreen
import com.example.coroutinechannel.ui.screens.MainScreen
import com.example.coroutinechannel.viewModel.home.HomeState

@Composable
fun HomeNavGraph(
    homeNavController: NavHostController,
    userDetail: UserDetail,
    mainNavController: NavHostController
) {
    NavHost(
        homeNavController,
        startDestination = MainPage
    ) {
        composable<MainPage> { entry ->
            MainScreen(
                data = HomeState(),
                onEvent = {},
                homeNavController,
                userDetail = userDetail,
                mainNavController
            )
        }
        composable<DetailPage>{ entry ->
            DetailScreen()
        }
    }
}