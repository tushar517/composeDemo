package com.example.coroutinechannel.di

import android.content.Context
import com.example.coroutinechannel.data.network.api.RestApi
import com.example.coroutinechannel.data.network.datasource.datastore.DataStoreAction
import com.example.coroutinechannel.data.network.datasource.datastore.DataStoreHelper
import com.example.coroutinechannel.data.network.datasource.remote.repository.Repository
import com.example.coroutinechannel.data.network.datasource.remote.repository.RepositoryImpl
import com.example.coroutinechannel.data.network.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(context: Context): RestApi {
        return RetrofitClient().buildApi(RestApi::class.java,context)
    }

    @Provides
    fun provideApplicationContext(@ApplicationContext application: Context): Context {
        return application
    }

    @Provides
    fun repository(restApi: RestApi): Repository {
        return RepositoryImpl(restApi)
    }

    @Provides
    fun dataStore(context: Context): DataStoreHelper{
        return DataStoreHelper(context)
    }
}