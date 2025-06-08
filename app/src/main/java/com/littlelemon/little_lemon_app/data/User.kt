package com.littlelemon.little_lemon_app.data

import android.content.Context

data class User(
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
)

object UserPreferences {

    private const val PREF_NAME = "user_prefs"

    fun saveUserData(context: Context, user: User) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().apply {
            putString("firstName", user.firstName)
            putString("lastName", user.lastName)
            putString("email", user.email)
            apply()
        }
    }

    fun getUserData(context: Context): User {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return User(
            firstName = sharedPreferences.getString("firstName", "") ?: "",
            lastName = sharedPreferences.getString("lastName", "") ?: "",
            email = sharedPreferences.getString("email", "") ?: "",
        )
    }

    fun isUserRegistered(context: Context): Boolean {
        val user = getUserData(context)
        return user.firstName.isNotBlank() && user.lastName.isNotBlank() && user.email.isNotBlank()
    }
}