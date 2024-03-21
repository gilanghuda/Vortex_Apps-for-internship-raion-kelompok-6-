package com.example.vortex.Start

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vortex.R

@Composable
fun TextComponent(textValue: String, size: TextUnit) {
    Text(
        text = textValue,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Black,
        style = TextStyle(
            fontSize = size,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Medium ,
        ),
        textAlign = TextAlign.Center
    )
}

@Composable
fun NormalTextField(
    text: String,
    onValueChange: (String) -> Unit,
    icon: Painter,
    labelValue: String
) {
//    val textValue = remember {
//        mutableStateOf("")
//    }
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        leadingIcon = { Icon(painter = icon, contentDescription = labelValue, modifier = Modifier.size(15.dp)) },
        shape = RoundedCornerShape(16.dp),
//        keyboardOptions = KeyboardOptions.Default,
//        keyboardActions = KeyboardActions.Default,
    )
}

@Composable
fun PasswordTextField(
    text: String,
    onValueChange: (String) -> Unit,
    icon: Painter,
    labelValue: String
) {
//    val textValue = remember {
//        mutableStateOf("")
//    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        leadingIcon = { Icon(painter = icon, contentDescription = labelValue, modifier = Modifier.size(15.dp)) },
        trailingIcon = {
            val icon = if (passwordVisible.value) R.drawable.ic_view else R.drawable.ic_hide
            val contentDescription = if (passwordVisible.value) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = contentDescription
                )
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//        keyboardActions = KeyboardActions.Default,
    )
}


@Composable
fun ButtonSign(textValue: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {onClick()}
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = textValue,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
fun MultiClickableTextComponent(initialTextValue: String, clickTextValue: String,  onClick: () -> Unit) {
    val initialText = initialTextValue
    val clickText = clickTextValue
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Blue)){
            pushStringAnnotation(tag = "clickable", annotation = clickText)
            append(clickText)
            pop()
        }
    }
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        ClickableText(text = annotatedString, onClick ={offset ->
            annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.let{
                if (it.tag == "clickable"){
                    onClick()
                }
            }
        }
        )
    }
}
@Composable
fun SingleClickableTextComponent(clickTextValue: String) {
    val clickText = clickTextValue
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Blue)){
            pushStringAnnotation(tag = clickText, annotation = clickText)
            append(clickText)
            pop()
        }
    }
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        ClickableText(text = annotatedString, onClick ={/*TODO*/ })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuBox(selectedBidang: String, onSelectedBidangChange: (String) -> Unit) {
    val context = LocalContext.current
    val bidang = arrayOf("Kuliner", "Teknologi", "Tekstil", "Aaa", "BBBBB")
    var expanded by remember { mutableStateOf(false) }

//    Box(modifier = Modifier.fillMaxWidth()) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = selectedBidang,
            onValueChange = { onSelectedBidangChange(it) },
            modifier = Modifier.fillMaxWidth().menuAnchor(),
            label = { Text("Bidang") },
            leadingIcon = { Icon(painter = painterResource(id = R.drawable.ic_bidangfix), contentDescription = null) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            readOnly = true,  // Keep it readOnly to prevent keyboard input
            singleLine = true,
            shape = RoundedCornerShape(16.dp)

        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            bidang.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onSelectedBidangChange(item)
                        expanded = false
                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

//TextField(
//modifier = Modifier.fillMaxWidth(),
//label = {Text(text = labelValue)},
//value = textValue.value,
//leadingIcon = { Icon(painter = icon, contentDescription = labelValue) },
//onValueChange = {
//    textValue.value = it
//},
//shape = RoundedCornerShape(16.dp),
//keyboardOptions = KeyboardOptions.Default,
//keyboardActions = KeyboardActions.Default,
//)