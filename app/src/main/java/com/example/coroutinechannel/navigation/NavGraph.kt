package com.example.coroutinechannel.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.coroutinechannel.ui.screens.HomeScreen
import com.example.coroutinechannel.ui.screens.LoginScreen
import com.example.coroutinechannel.ui.screens.SearchResultScreen
import com.example.coroutinechannel.viewModel.home.HomeViewModel
import com.example.coroutinechannel.viewModel.login.LoginViewModel
import kotlin.reflect.typeOf

@Composable
fun HomeGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Login,
    ) {
        composable<Login> {
            val viewModel = hiltViewModel<LoginViewModel>()
            val data = viewModel.state.collectAsStateWithLifecycle()
            LoginScreen(
                data = data.value,
                onEvent = viewModel::onEvent,
                navHostController
            )
        }
        composable<Home>(
            typeMap = mapOf(typeOf<UserDetail>() to CustomNavType(
                kClass = UserDetail::class,
                serializer = UserDetail.serializer()
            ))
        ) { entry ->
            val value = entry.toRoute<Home>()
            val viewModel = hiltViewModel<HomeViewModel>()
            val data = viewModel.state.collectAsStateWithLifecycle()
            HomeScreen(
                data = data.value,
                onEvent = viewModel::onEvent,
                navHostController,
                userDetail = value.userDetail
            )
        }
        composable<SearchResult> { entry ->
            SearchResultScreen(
                navHostController
            )
        }
    }
}