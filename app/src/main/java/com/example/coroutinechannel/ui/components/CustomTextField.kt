package com.example.coroutinechannel.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.example.coroutinechannel.ui.theme.typography
import com.example.coroutinechannel.ui.theme.black_1A
import com.example.coroutinechannel.ui.theme.grey_CD

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyBoardType: KeyboardType,
    modifier: Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    icon: @Composable ()->Unit={}
) {
    OutlinedTextField(
        value =value,
        onValueChange = onValueChange,
        label = {
            Text(
                label,
                style = typography.bodySmall.copy(fontSize = 14.sp)
            )
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = black_1A,
            unfocusedLabelColor = grey_CD,
            focusedBorderColor = black_1A,
            unfocusedBorderColor = grey_CD,
            focusedTextColor = black_1A,
            unfocusedTextColor = black_1A
        ),
        textStyle = typography.bodyMedium,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType,
        ),
        modifier = modifier.fillMaxWidth(),
        visualTransformation =  visualTransformation,
        trailingIcon = icon
    )
}
