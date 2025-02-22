package com.example.coroutinechannel.data.network.datasource.datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.dataStore by preferencesDataStore(name = "PreferenceDataStore")
class DataStoreHelper(context: Context):DataStoreAction {
    private val dataSource = context.dataStore

    override suspend fun <T> getData(key: Preferences.Key<T>, defaultValue: T):
            Flow<T> = dataSource.data.catch { exception ->
        if (exception is IOException){
            emit(emptyPreferences())
        }else{
            throw exception
        }
    }.map { preferences->
        val result = preferences[key]?: defaultValue
        result
    }

    override suspend fun <T> setData(key: Preferences.Key<T>, value: T) {
        dataSource.edit {preferences -> preferences[key] = value }
    }

    override suspend fun <T> removePreference(key: Preferences.Key<T>) {
        dataSource.edit { preferences ->
            preferences.remove(key)
        }
    }

    override suspend fun clearAllPreference() {
        dataSource.edit { preferences ->
            preferences.clear()
        }
    }
}