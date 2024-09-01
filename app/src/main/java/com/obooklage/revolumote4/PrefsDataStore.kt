package com.obooklage.revolumote4

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "FreeboxSettings")

class PrefsDataStore(ctx: Context) {
    private val CODE_TELECOMMANDE = stringPreferencesKey("code")

    suspend fun saveCodeToPreferencesStore(code: String, ctx: Context) {
        ctx.dataStore.edit { preferences ->
            preferences[CODE_TELECOMMANDE] = code


            /*
            // Display Data On UI
            runOnUiThread {
                binding.apply {
                    userName.text = "Username: $name"
                    txtEmail.text = "Email: $email"
                }
            }
            */
        }
    }

    suspend fun readCodeToPreferencesStore(ctx: Context) {
        ctx.dataStore.data.collect { preferences ->
            val code = preferences[CODE_TELECOMMANDE] ?: "" // "none"

            Log.e("SETTINGS","Code télécommande LU =[" + code + "]")

            /*
                        // Display Data On UI
                        runOnUiThread {
                            binding.apply {
                                userName.text = "Username: $name"
                                txtEmail.text = "Email: $email"
                            }
                        }
                        */

        }
    }

}