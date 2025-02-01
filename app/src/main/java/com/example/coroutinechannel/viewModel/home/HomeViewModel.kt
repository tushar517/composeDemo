package com.example.coroutinechannel.viewModel.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor():ViewModel() {
    private val homeState= MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> get() = homeState

    fun onEvent(event: HomeEvent){

    }
}