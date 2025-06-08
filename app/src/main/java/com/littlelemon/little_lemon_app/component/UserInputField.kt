package com.littlelemon.little_lemon_app.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.littlelemon.little_lemon_app.R

@Composable
fun UserInputField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes labelResId: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
    enabled: Boolean,
    textStyle: TextStyle = TextStyle.Default
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        fieldLabel(labelResId) // Usando la función de etiqueta que ya tienes
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            shape = RoundedCornerShape(8.dp),
            enabled = enabled,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp)
            //.height(44.dp),
            //textStyle = TextStyle(fontSize = 12.sp)

        )
    }
}

@Composable
fun fieldLabel(id: Int) {
    Text(
        modifier = Modifier.padding(
            start = 25.dp
        ),
        text = stringResource(id),
        fontSize = 18.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily(
            Font(R.font.karlaregular)
        )
    )
}