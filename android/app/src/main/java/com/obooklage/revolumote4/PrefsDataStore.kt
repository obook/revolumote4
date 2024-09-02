package com.obooklage.revolumote4

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "FreeboxSettings")

class PrefsDataStore(ctx: Context) {
    private val CODE_KEY = stringPreferencesKey("code")

    suspend fun saveCodeToPreferencesStore(code: String, ctx: Context) {
        ctx.dataStore.edit { preferences ->
            preferences[CODE_KEY] = code
        }
    }

    // Create a name flow to retrieve remote code string from the preferences
    val codeFlow: Flow<String> = ctx.dataStore.data.map {
        it[CODE_KEY] ?: ""
    }
}