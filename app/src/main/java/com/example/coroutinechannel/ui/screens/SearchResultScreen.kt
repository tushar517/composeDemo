package com.example.coroutinechannel.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coroutinechannel.navigation.SearchModel
import com.example.coroutinechannel.ui.theme.typography

@Composable
fun SearchResultScreen(search: SearchModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Search Query: ${search.query}",style = typography.bodyLarge)
        Spacer(Modifier
            .height(20.dp))
        Text("Search Count: ${search.count}", style = typography.bodyLarge)
    }
}