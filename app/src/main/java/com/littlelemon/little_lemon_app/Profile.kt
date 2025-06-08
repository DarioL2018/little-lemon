package com.littlelemon.little_lemon_app

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.little_lemon_app.component.ButtonLittleLemon
import com.littlelemon.little_lemon_app.component.TopAppBar
import com.littlelemon.little_lemon_app.component.UserInputField
import com.littlelemon.little_lemon_app.data.UserPreferences

@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val spaceValue: Dp = 40.dp
    var user = UserPreferences.getUserData(context)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            TopAppBar()
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                modifier = Modifier.padding(
                    start = 25.dp),
                text = stringResource(R.string.information_subtitle).uppercase(),
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(
                    Font(R.font.karlaregular)
                )
            )

            Spacer(modifier = Modifier.height(spaceValue))
            UserInputField(
                value = user.firstName,
                onValueChange = {  },
                labelResId = R.string.first_name,
                keyboardType = KeyboardType.Text,
                enabled = false,
                textStyle = TextStyle(color = Color.Black)
            )

            Spacer(modifier = Modifier.height(spaceValue))

            UserInputField(
                value = user.lastName,
                onValueChange = {  },
                labelResId = R.string.last_name,
                keyboardType = KeyboardType.Text,
                enabled = false,
                textStyle = TextStyle(color = Color.Black)
            )

            Spacer(modifier = Modifier.height(spaceValue))

            UserInputField(
                value = user.email,
                onValueChange = {  },
                labelResId = R.string.email,
                keyboardType = KeyboardType.Email,
                enabled = false,
                textStyle = TextStyle(color = Color.Black)
            )

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
        ) {
            ButtonLittleLemon(
                text = "Log out",
                onClick = {
                    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                    sharedPreferences.edit().clear().apply()
                    navController.navigate(Onboarding.route)
                }
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    Profile(rememberNavController())
}
