package net.blakely.paul.sportsball.preferences

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by Paul on 5/25/2017.
 */

const val HIGH_SCORE = "HIGH_SCORE"

class PreferencesManager @Inject constructor(val preferences: SharedPreferences) {
    var highScore: Int
        get() = getInt(HIGH_SCORE)
        set(value) {
            putInt(HIGH_SCORE, value)
        }

    private fun getInt(key: String): Int {
        return preferences.getInt(key, 0)
    }

    private fun putInt(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

    private fun getFloat(key: String): Float {
        return preferences.getFloat(key, 0f)
    }

    private fun putFloat(key: String, value: Float) {
        preferences.edit().putFloat(key, value).apply()
    }

    private fun getString(key: String): String {
        return preferences.getString(key, "")
    }

    private fun putString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    private fun getBoolean(key: String, default: Boolean = false): Boolean {
        return preferences.getBoolean(key, default)
    }

    private fun putBoolean(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }
}