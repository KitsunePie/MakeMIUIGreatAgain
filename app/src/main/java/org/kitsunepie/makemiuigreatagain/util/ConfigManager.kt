package org.kitsunepie.makemiuigreatagain.util

import android.content.Context

object ConfigManager {
    object AppSettings {
        val sAppPrefs by lazy {
            sAppContext.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        }

        var inactiveDialog: Boolean
            set(value) = sAppPrefs.edit().putBoolean("inactive_dialog", value).apply()
            get() = sAppPrefs.getBoolean("inactive_dialog", true)

    }

    object ModuleSettings {
        var successLoad: Boolean = false
            private set
    }
}