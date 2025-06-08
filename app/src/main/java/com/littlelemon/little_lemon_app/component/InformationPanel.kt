package com.littlelemon.little_lemon_app.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.littlelemon.little_lemon_app.R
import com.littlelemon.little_lemon_app.ui.theme.LittleLemonColor

@Composable
fun InformationPanel(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
            .background(LittleLemonColor.green)
            .height(158.dp)
    ) {
        Text(
            color = Color.White,
            text = stringResource(id = R.string.information_title),
            fontSize = 40.sp,
            fontFamily = FontFamily(
                Font(R.font.markazitextregular)
            )
        )
    }
}