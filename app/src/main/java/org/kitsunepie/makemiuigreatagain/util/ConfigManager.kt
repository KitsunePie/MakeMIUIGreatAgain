package org.kitsunepie.makemiuigreatagain.util

import android.content.Context

object ConfigManager {
    object AppSettings {
        val sAppPrefs by lazy {
            sAppContext.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        }

        fun putBool(key: String, value: Boolean) {
            sAppPrefs.edit().putBoolean(key, value).apply()
        }

        fun getBool(key: String, defValue: Boolean = false): Boolean {
            return sAppPrefs.getBoolean(key, defValue)
        }

        fun putString(key: String, value: String) {
            sAppPrefs.edit().putString(key, value).apply()
        }

        fun getString(key: String, defValue: String = ""): String {
            return sAppPrefs.getString(key, defValue) ?: defValue
        }

        fun putStringSet(key: String, value: Set<String>) {
            sAppPrefs.edit().putStringSet(key, value).apply()
        }

        fun getStringSet(key: String, defValue: Set<String> = emptySet()): Set<String> {
            return sAppPrefs.getStringSet(key, defValue) ?: emptySet()
        }

        fun putInt(key: String, value: Int) {
            sAppPrefs.edit().putInt(key, value).apply()
        }

        fun getInt(key: String, defValue: Int = 0): Int {
            return sAppPrefs.getInt(key, defValue)
        }

        fun putFloat(key: String, value: Float) {
            sAppPrefs.edit().putFloat(key, value).apply()
        }

        fun getFloat(key: String, defValue: Float = 0.0f): Float {
            return sAppPrefs.getFloat(key, defValue)
        }

        fun putLong(key: String, value: Long) {
            sAppPrefs.edit().putLong(key, value).apply()
        }

        fun getLong(key: String, defValue: Long = 0L): Long {
            return sAppPrefs.getLong(key, defValue)
        }

        var inactiveDialog: Boolean
            set(value) = putBool("inactive_dialog", value)
            get() = getBool("inactive_dialog", true)

    }

    object ModuleSettings {
        var successLoad: Boolean = false
            private set
    }
}