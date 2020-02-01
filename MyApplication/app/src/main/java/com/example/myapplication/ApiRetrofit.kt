package com.example.myapplication

import android.util.Base64
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiRetrofit {

    private val AUTH = "Basic"+ Base64.encodeToString("root: ".toByteArray(),Base64.NO_WRAP)
    private val base_Url:String? = "C:\\xampp\\mysql\\data\\kotlin"

    private val okHttpClien  = OkHttpClient.Builder()
        .addInterceptor {chain ->  
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .addHeader("Authorization", AUTH)
                .method(original.method(), original.body())

            val request =requestBuilder.build()
            chain.proceed(request)
        }

    val instance: ApiRetrofit by lazy {
        val retrofit = Retrofit.Builder()
        retrofit.baseUrl(base_Url)
        retrofit.addConverterFactory(GsonConverterFactory.create())
        retrofit.client(okHttpClien)
            .build()

        retrofit.create()
    }
}