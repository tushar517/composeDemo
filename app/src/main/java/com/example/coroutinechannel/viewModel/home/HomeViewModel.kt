package com.example.coroutinechannel.viewModel.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.coroutinechannel.navigation.Home
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
):ViewModel() {
    private val homeState= MutableStateFlow(HomeState())
//    val savedetail = savedStateHandle.toRoute<Home>()
    val state: StateFlow<HomeState> get() = homeState.onStart {
        homeState.value = homeState.value.copy(
            /*userName = savedetail.userDetail.userName,
            password = savedetail.userDetail.password*/
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeState()
    )
    fun onEvent(event: HomeEvent){

    }
}