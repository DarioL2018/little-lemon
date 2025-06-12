package com.littlelemon.little_lemon_app.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.littlelemon.little_lemon_app.MenuItemRoom
import com.littlelemon.little_lemon_app.ui.theme.CustomTextStyles
import com.littlelemon.little_lemon_app.ui.theme.LittleLemonColor
import java.util.Locale

@Composable
//fun LowerPanel(navController: NavHostController, dishes: List<Dish> = listOf()) {
fun MenuItems(databaseMenuItems: List<MenuItemRoom> = listOf(),  filterPhrase: String){
    var categoryFilter by remember { mutableStateOf("") }
    val menuItemsByCategory: Map<String, List<MenuItemRoom>> = databaseMenuItems.groupBy { it.category }
    val categoriesList = menuItemsByCategory.keys.toList()

    Column(
        Modifier.padding(start = 25.dp, end = 25.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Categories(categoriesList, onGroupUpdate = { cat -> categoryFilter = cat })


        var filteredMenuItems = databaseMenuItems

        if (filterPhrase.isNotEmpty()) {
             filteredMenuItems = filteredMenuItems.filter { it.title.contains(filterPhrase, ignoreCase = true) }

        }

        if (categoryFilter.isNotEmpty()) {
            //filteredMenuItems = menuItemsByCategory.getOrDefault(categoryFilter, listOf() )
            filteredMenuItems = filteredMenuItems.filter { it.category.equals(categoryFilter, ignoreCase = true) }
        }

        LazyColumn {
            itemsIndexed(filteredMenuItems) { _, dish ->
                MenuDish(dish)
            }
        }
    }
}

@Composable
fun Categories(categories: List<String>, onGroupUpdate: (String) -> Unit) {
    var selectedFilter by remember { mutableStateOf<String?>(null) }
    Column {
        Text(
            text = "ORDER FOR DELIVERY!",
            style = CustomTextStyles.sectionTitle,
            color = Color.Black,
            modifier = Modifier
                .padding(8.dp)

        )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        userScrollEnabled = true
    ) {
        items(categories) { text ->
            Button(
                onClick = {
                    selectedFilter = if (selectedFilter == text) null else text
                    onGroupUpdate(if(selectedFilter == null) "" else text)
                          },
                modifier = Modifier.padding(8.dp),
                colors = ButtonColors(
                    containerColor = if (selectedFilter == text) LittleLemonColor.charcoal else LittleLemonColor.cloud ,
                    contentColor = LittleLemonColor.green,
                    disabledContainerColor = ButtonDefaults.buttonColors().disabledContainerColor,
                    disabledContentColor = ButtonDefaults.buttonColors().disabledContentColor
                ),
                shape = RoundedCornerShape(percent = 8),

                ) {
                Text(text.replaceFirstChar { if (it. isLowerCase()) it. titlecase(Locale. getDefault()) else it. toString() })
            }
        }

    }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
//fun MenuDish(navController: NavHostController? = null, dish: Dish) {
fun MenuDish(dish: MenuItemRoom){
    Card(
        shape = RoundedCornerShape(percent = 0),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = CardDefaults.cardColors().contentColor,
            disabledContainerColor = CardDefaults.cardColors().disabledContainerColor,
            disabledContentColor = CardDefaults.cardColors().disabledContentColor
        ),
        modifier = Modifier
            .background(Color(0xFFEDEFEE)),
        onClick = {
        //navController?.navigate(DishDetails.route + "/${dish.id}")
    }) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(

            ) {
                Text(
                    text = dish.title,
                    style = CustomTextStyles.cardTitle,
                    color = Color.Black
                )
                Text(
                    text = "The famous greek salad of crispy lettuce, peppers, olives and our Chicago style feta cheese, garnished with crunchy garlic and rosemary croutons. ", //dish.description,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .padding(top = 10.dp, bottom = 10.dp),
                    style = CustomTextStyles.paragraph,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    color = LittleLemonColor.green
                )
                Text(
                    text = "${dish.price}",
                    color = LittleLemonColor.green,
                    style = CustomTextStyles.highlightText
                )
            }
            GlideImage(
                model = dish.image,
                contentDescription = dish.description,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(percent = 10)
                    )
                    .size(83.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = Color(0xFFEDEFEE)
    )
}

