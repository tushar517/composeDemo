package com.example.coroutinechannel.ui.components

import android.graphics.pdf.models.ListItem
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coroutinechannel.ui.theme.itemCardGradient
import com.example.coroutinechannel.ui.theme.typography
import com.example.coroutinechannel.ui.theme.white
import com.example.coroutinechannel.ui.theme.white_C8

@Composable
fun ListItem(
    awb:Long,
    desc:String
) {
    Column(
        modifier = Modifier.fillMaxWidth().background(
            brush = itemCardGradient,
            shape = RoundedCornerShape(22.dp),
        ).border(
            width = 1.dp,
            color = white_C8,
            shape = RoundedCornerShape(22.dp)
        )
    ){
        Text(
            text = awb.toString(),
            style = typography.bodyMedium.copy(
                color = white_C8
            ),
            modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)
        )
        Text(
            text = desc,
            style = typography.bodySmall.copy(
                color = white
            ),
            modifier = Modifier.padding(top = 5.dp, start = 15.dp, end = 15.dp, bottom = 15.dp)
        )
    }
}