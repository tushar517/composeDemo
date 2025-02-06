package com.example.coroutinechannel.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.coroutinechannel.R
import com.example.coroutinechannel.navigation.HomeNavGraph
import com.example.coroutinechannel.navigation.SettingNavGraph
import com.example.coroutinechannel.navigation.UserDetail
import com.example.coroutinechannel.ui.theme.bottomNavCardGradient
import com.example.coroutinechannel.viewModel.home.HomeEvent
import com.example.coroutinechannel.viewModel.home.HomeState
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    data: HomeState,
    onEvent: (HomeEvent) -> Unit = { },
    navHostController: NavHostController,
    userDetail: UserDetail
) {

    var selectedItem by remember {
        mutableIntStateOf(1)
    }
    val pagerState = rememberPagerState { 2 }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = bottomNavCardGradient,
                        shape = RoundedCornerShape(55.dp)
                    ),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = if (selectedItem == 1) R.drawable.selected_chat_bottom_nav else R.drawable.unselected_chat_bottom_nav),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {
                            selectedItem = 1
                            coroutineScope.launch {
                                pagerState.scrollToPage(0)
                            }
                        }
                        .padding(10.dp)
                )
                Image(
                    painter = painterResource(id = if (selectedItem == 2) R.drawable.selected_setting_bottom_nav else R.drawable.unselected_setting_bottom_nav),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {
                            selectedItem = 2
                            coroutineScope.launch {
                                pagerState.scrollToPage(1)
                            }
                        }
                        .padding(10.dp)
                )
            }
        },
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        Column(modifier = Modifier.padding(it)) {
            HorizontalPager(
                pagerState,
                userScrollEnabled = false
            ) { page: Int ->
                if (page == 0) {
                    val dashBoardNavController = rememberNavController()
                    HomeNavGraph(
                        dashBoardNavController,
                        userDetail,
                        navHostController
                    )
                } else {
                    val settingNavGraph = rememberNavController()
                    SettingNavGraph(
                        settingNavGraph,
                        userDetail,
                        navHostController
                    )
                }
            }
        }
    }
}
