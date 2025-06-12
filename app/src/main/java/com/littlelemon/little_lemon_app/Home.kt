package com.littlelemon.little_lemon_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.littlelemon.little_lemon_app.component.HeroSection
import com.littlelemon.little_lemon_app.component.MenuItems
import com.littlelemon.little_lemon_app.component.TopBarHome

@Composable
fun HomeScreen(navController: NavHostController, database: AppDatabase) {
    val databaseMenuItems by database.menuItemDao().getAll().observeAsState(emptyList())
    var filterPhrase by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopBarHome(navController)
        HeroSection(onSearchUpdated = { newFilter -> filterPhrase = newFilter })
        MenuItems(databaseMenuItems, filterPhrase )
    }
}
