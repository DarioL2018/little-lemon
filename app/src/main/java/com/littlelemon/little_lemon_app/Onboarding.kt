package com.littlelemon.little_lemon_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.little_lemon_app.component.ButtonLittleLemon
import com.littlelemon.little_lemon_app.component.InformationPanel
import com.littlelemon.little_lemon_app.component.TopAppBar
import com.littlelemon.little_lemon_app.component.UserInputField
import com.littlelemon.little_lemon_app.data.User
import com.littlelemon.little_lemon_app.data.UserPreferences
import com.littlelemon.little_lemon_app.ui.theme.LittleLemonColor

@Composable
fun Onboarding(navController: NavController){
    val context = LocalContext.current
    val spaceValue: Dp = 40.dp
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var showSuccessDialog by remember { mutableStateOf(false) }
    val failedMessage = stringResource(R.string.registration_failed)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        TopAppBar()
        InformationPanel()
        Spacer(modifier = Modifier.height(spaceValue))
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
        if (message.isBlank() )
            Spacer(modifier = Modifier.height(spaceValue))
        else
            Text(
                text = message,
                color = Color.Red,
                modifier = Modifier
                    .padding(
                        start = 25.dp,
                        end = 25.dp,
                        bottom = 25.dp
                    )
            )


        UserInputField(
            value = firstName,
            onValueChange = { firstName = it },
            labelResId = R.string.first_name,
            keyboardType = KeyboardType.Text,
            enabled = true
        )

        Spacer(modifier = Modifier.height(spaceValue))

        UserInputField(
            value = lastName,
            onValueChange = { lastName = it },
            labelResId = R.string.last_name,
            keyboardType = KeyboardType.Text,
            enabled = true
        )

        Spacer(modifier = Modifier.height(spaceValue))

        UserInputField(
            value = email,
            onValueChange = { email = it },
            labelResId = R.string.email,
            keyboardType = KeyboardType.Email,
            enabled = true
        )

    }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
        ) {
            ButtonLittleLemon(
                text = "Register",
                onClick = {
                    if (firstName.isBlank() || lastName.isBlank() || email.isBlank()) {
                        message = failedMessage
                        showSuccessDialog = false
                    } else {
                        val user = User(firstName, lastName, email)
                        UserPreferences.saveUserData(context = context, user)
                        showSuccessDialog = true
                        message = ""
                    }
                }
            )
        }

        if (showSuccessDialog) {
            AlertDialog(
                onDismissRequest = { showSuccessDialog = false },
                confirmButton = {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LittleLemonColor.yellow,
                            contentColor = Color.Black
                        ),
                        onClick = {
                        showSuccessDialog = false
                        navController.navigate(route = Home.route)
                    }) {
                        Text(text = "Accept")
                    }
                },
                title = { Text(text = stringResource(R.string.registration_success)) },
            )
        }
    }

}

@Preview
@Composable
fun OnboardingPreview(){
    Onboarding(rememberNavController())
}