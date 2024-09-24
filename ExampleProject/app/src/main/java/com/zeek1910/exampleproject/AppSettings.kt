package com.zeek1910.exampleproject

import android.content.Context

class AppSettings private constructor(context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var isUserLogin: Boolean
        get() = pref.getBoolean(KEY_IS_USER_LOGIN, false)
        set(value) = pref.edit().putBoolean(KEY_IS_USER_LOGIN, value).apply()

    fun createUser(name: String, email: String, password: String) {
        pref.edit().putString(KEY_USER_NAME, name).apply()
        pref.edit().putString(KEY_USER_EMAIL, email).apply()
        pref.edit().putString(KEY_USER_PASSWORD, password).apply()
    }

    fun getUser(): User? {
        val name = pref.getString(KEY_USER_NAME, null) ?: return null
        val email = pref.getString(KEY_USER_EMAIL, null) ?: return null
        val password = pref.getString(KEY_USER_PASSWORD, null) ?: return null
        return User(name, email, password)
    }

    companion object {
        private const val PREF_NAME = "main_pref"
        private const val KEY_IS_USER_LOGIN = "KEY_IS_USER_LOGIN"
        private const val KEY_USER_NAME = "KEY_USER_NAME"
        private const val KEY_USER_EMAIL = "KEY_USER_EMAIL"
        private const val KEY_USER_PASSWORD = "KEY_USER_PASSWORD"

        private var instance: AppSettings? = null
        fun getInstance(context: Context): AppSettings {
            if (instance == null) {
                instance = AppSettings(context)
            }
            return requireNotNull(instance)
        }
    }
}