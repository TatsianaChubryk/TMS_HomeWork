package com.example.homework.hw.homework.lesson27

import com.example.homework.hw.homework.lesson27.model.Lipstick
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.http.GET
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface ApiLipstick {

    @GET("products.json?brand=covergirl&product_type=lipstick") //то что после v1
    fun getLipstick(): Call<Lipstick>

    companion object {
        private const val BASE_URL = "http://makeup-api.herokuapp.com/api/v1/"
        private val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val okHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()

        fun create(): ApiLipstick {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create()) //конвектор, который преобразовывает запрос
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
            return retrofit.create(ApiLipstick::class.java)
        }
    }
}