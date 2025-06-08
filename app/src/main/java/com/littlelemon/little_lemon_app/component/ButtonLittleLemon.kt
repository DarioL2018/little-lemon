package com.littlelemon.little_lemon_app.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.littlelemon.little_lemon_app.R
import com.littlelemon.little_lemon_app.ui.theme.LittleLemonColor

@Composable
fun ButtonLittleLemon(
    onClick: () -> Unit,
    text: String
){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(
                start = 25.dp,
                end = 25.dp
            )
            .height(52.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = LittleLemonColor.yellow,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(
                Font(R.font.karlaregular)
            )
        )
    }
}