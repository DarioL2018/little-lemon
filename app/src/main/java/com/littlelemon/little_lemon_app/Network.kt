package com.littlelemon.little_lemon_app

import kotlinx.serialization.Serializable

@Serializable
data class MenuNetwork(
    var menu: List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    var id: Int,
    var title: String,
    var description: String,
    var price: String,
    var image: String,
    var category: String
) {
    fun toMenuItemRoom() = MenuItemRoom(
        id = id,
        title = title,
        description = description,
        price = price.toDouble(),
        image = image,
        category = category
    )
}
