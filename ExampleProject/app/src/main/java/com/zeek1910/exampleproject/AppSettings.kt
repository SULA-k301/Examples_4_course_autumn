package com.zeek1910.exampleproject

import android.content.Context

class AppSettings private constructor(context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var isUserLogin: Boolean
        get() = pref.getBoolean(KEY_IS_USER_LOGIN, false)
        set(value) = pref.edit().putBoolean(KEY_IS_USER_LOGIN, value).apply()

    var isFirstRun: Boolean
        get() = pref.getBoolean(KEY_IS_FIRST_RUN, true)
        set(value) = pref.edit().putBoolean(KEY_IS_FIRST_RUN, value).apply()

    companion object {
        private const val PREF_NAME = "main_pref"
        private const val KEY_IS_USER_LOGIN = "KEY_IS_USER_LOGIN"
        private const val KEY_IS_FIRST_RUN = "KEY_IS_FIRST_RUN"

        private var instance: AppSettings? = null
        fun getInstance(context: Context): AppSettings {
            if (instance == null) {
                instance = AppSettings(context)
            }
            return requireNotNull(instance)
        }
    }
}