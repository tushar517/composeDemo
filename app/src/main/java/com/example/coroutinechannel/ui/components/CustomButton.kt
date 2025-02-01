package com.example.coroutinechannel.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coroutinechannel.ui.theme.typography
import com.example.coroutinechannel.ui.theme.blue_8F
import com.example.coroutinechannel.ui.theme.grey_D8
import com.example.coroutinechannel.ui.theme.white

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    isEnable: Boolean,
    modifier: Modifier

) {
    Button(
        onClick = { onClick() },
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = grey_D8,
            containerColor = blue_8F
        ),
        enabled = isEnable,
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            text,
            style = typography.bodyMedium.copy(
                color = white
            ),
            modifier = Modifier.padding(vertical = 10.dp)

        )
    }
}