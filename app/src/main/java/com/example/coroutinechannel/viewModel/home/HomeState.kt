package com.example.coroutinechannel.viewModel.home

data class HomeState(
    var isLoading: Boolean = false,
    val userName: String = "",
    val password: String = ""
)
