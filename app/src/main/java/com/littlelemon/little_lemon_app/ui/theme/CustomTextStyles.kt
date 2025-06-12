package com.littlelemon.little_lemon_app.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.littlelemon.little_lemon_app.R

object CustomTextStyles {

    val display = TextStyle(
        fontSize = 64.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(
            Font(R.font.markazitextregular)
        )
    )

    val subtitle = TextStyle(
        fontSize = 40.sp,
        fontFamily = FontFamily(
            Font(R.font.markazitextregular)
        )
    )

    val leadText = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(
            Font(R.font.karlaregular)
        )
    )

    val sectionTitle = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily(
            Font(R.font.karlaregular)
        )
    )

    val sectionCategories = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily(
            Font(R.font.karlaregular)
        )
    )

    val cardTitle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(
            Font(R.font.karlaregular)
        )
    )
    val paragraph = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(
            Font(R.font.karlaregular)
        ),
        //lineHeight = (1.5).sp
    )
    val highlightText = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(
            Font(R.font.karlaregular)
        ),

    )

}