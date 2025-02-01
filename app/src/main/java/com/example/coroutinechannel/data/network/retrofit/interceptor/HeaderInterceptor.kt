package com.example.coroutinechannel.data.network.retrofit.interceptor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.util.prefs.Preferences
import javax.inject.Inject

class HeaderInterceptor :
    Interceptor {

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    override fun intercept(chain: Interceptor.Chain): Response = runBlocking {
        val originalRequest: Request = chain.request()
        val modifiedRequest: Request = originalRequest.newBuilder()
            .header("Content-Type", "application/json")
//            .header(AUTH_TOKEN,getToken(aUTH_TOKEN,"").await())
            .header("app_code", "SCA")
//            .header(auth_required, "YES")
            .header("Device", "Android")
            .build()
        chain.proceed(modifiedRequest)
    }

/*    private fun getToken(key: Preferences.Key<String>, defaultValue: String) =
        coroutineScope.async {
            preferenceDataStoreHelper.getData(key, defaultValue).first().toString()
        }*/
}
