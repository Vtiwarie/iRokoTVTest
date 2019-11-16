package com.example.irokutest.api

import android.content.Context
import com.example.irokutest.R
import com.example.irokutest.inject.ForApplication
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class NetworkInterceptor @Inject constructor() : Interceptor {
    @Inject
    @field:ForApplication
    lateinit var context: Context
    
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = context.getString(R.string.api_key)
        val request = chain.request()
                .newBuilder()
                .header("Api-Key", apiKey)
                .build()
        
        return chain.proceed(request)
    }
}
