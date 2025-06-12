package com.littlelemon.little_lemon_app.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.littlelemon.little_lemon_app.R
import com.littlelemon.little_lemon_app.ui.theme.CustomTextStyles
import com.littlelemon.little_lemon_app.ui.theme.LittleLemonColor

@Composable
fun HeroSection(onSearchUpdated: (String) -> Unit) {
    var searchPhrase by remember {
        mutableStateOf(value = "")
    }
    Column(
        modifier = Modifier
            .background(LittleLemonColor.green)
            .padding(start = 25.dp, end = 25.dp, top = 8.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.title),
            style = CustomTextStyles.display,
            color = LittleLemonColor.yellow,
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
            ) {
                Text(
                    text = stringResource(id = R.string.location),
                    style = CustomTextStyles.subtitle,
                    color = Color.White,
                )
                Text(
                    text = stringResource(id = R.string.description),
                    style = CustomTextStyles.leadText,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .fillMaxWidth(0.6f),
                    color = Color.White
                )
            }

            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "Upper Panel Image",
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
                    .padding(top = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = searchPhrase,
            onValueChange = {
                searchPhrase = it
                onSearchUpdated(searchPhrase)
            },
            placeholder = {
                Text(
                    text = "Enter search phrase"
                )
            },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
                //.height(50.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            }
        )
    }
}


