package com.littlelemon.little_lemon_app

interface Destinations {
    val route: String
}

object Onboarding : Destinations {
    override val route = "onboarding"
}

object Home : Destinations {
    override val route = "home"
}

object Profile : Destinations {
    override val route = "profile"
}