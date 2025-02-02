package com.example.coroutinechannel.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.coroutinechannel.R
import com.example.coroutinechannel.navigation.SearchResult
import com.example.coroutinechannel.navigation.UserDetail
import com.example.coroutinechannel.ui.components.CustomButton
import com.example.coroutinechannel.ui.components.ListItem
import com.example.coroutinechannel.ui.theme.black_16
import com.example.coroutinechannel.ui.theme.bottomNavCardGradient
import com.example.coroutinechannel.ui.theme.typography
import com.example.coroutinechannel.viewModel.home.HomeEvent
import com.example.coroutinechannel.viewModel.home.HomeState

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
    Box(modifier = Modifier.background(black_16)) {
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
                            }
                            .padding(10.dp)
                    )
                    Image(
                        painter = painterResource(id = if (selectedItem == 2) R.drawable.selected_setting_bottom_nav else R.drawable.unselected_setting_bottom_nav),
                        contentDescription = "",
                        modifier = Modifier
                            .clickable {
                                selectedItem = 2
                            }
                            .padding(10.dp)
                    )
                }
            },
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars),
            containerColor = black_16
        ) {
            Column(modifier = Modifier.padding(it)) {
                if (selectedItem == 1) {
                    HomeScreen2()

                } else {
                    HomeScreen1(
                        data,
                        onEvent,
                        navHostController,
                        userDetail
                    )
                }
            }
        }
    }
}

@Composable
internal fun HomeScreen1(
    data: HomeState,
    onEvent: (HomeEvent) -> Unit = { },
    navHostController: NavHostController,
    userDetail: UserDetail
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("userName: ${userDetail.userName}", style = typography.bodyLarge)
        Spacer(
            Modifier
                .height(20.dp)
        )
        Text("password: ${userDetail.password}", style = typography.bodyLarge)
        navHostController.currentBackStackEntry?.savedStateHandle?.get<String>("query")
            ?.let { searchQuery ->
                Spacer(
                    Modifier
                        .height(20.dp)
                )
                Text("password: ${searchQuery}", style = typography.bodyLarge)
            }
        CustomButton(
            text = "Get Code",
            onClick = {
                navHostController.navigate(SearchResult(""))
            },
            modifier = Modifier.padding(top = 30.dp),
            isEnable = true
        )
    }
}

@Composable
fun HomeScreen2() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        ListItem(42342344,"fdasfdas")
    }

}