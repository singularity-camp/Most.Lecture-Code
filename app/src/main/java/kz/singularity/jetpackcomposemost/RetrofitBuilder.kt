package kz.singularity.jetpackcomposemost

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

    private fun getRetrofit() : Retrofit {
//        val okHttpClient = OkHttpClient.Builder()
//            .
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .client()
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}
