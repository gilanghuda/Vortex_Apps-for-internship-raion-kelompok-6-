package com.example.vortex.Profil

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TransparentTextField(labelValue: String, textValue: String) {
    var text by remember { mutableStateOf(textValue) }

    TextField(
        label = { Text(text = labelValue)},
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.LightGray,
            unfocusedTextColor = Color.LightGray,
            focusedTextColor = Color.Black,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent, // Hide the indicator
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}