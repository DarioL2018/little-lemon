package com.littlelemon.little_lemon_app.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.little_lemon_app.Profile
import com.littlelemon.little_lemon_app.R

@Composable
fun TopBarHome(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 30.dp, bottom = 35.dp),
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .width(179.dp)
                .height(56.dp)
                .align(Alignment.Center)
        )

        IconButton(onClick = {
            navController.navigate(Profile.route)
        },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 25.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(56.dp)

            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun TopBarHomePreview() {
    TopBarHome(rememberNavController())
}