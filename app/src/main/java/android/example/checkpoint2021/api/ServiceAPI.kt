package android.example.checkpoint2021.api

import android.example.checkpoint2021.model.ItemItem
import retrofit2.Call
import retrofit2.http.GET

interface ServiceAPI {
    @GET("ncafe/products/county/")
    fun getAllItems(): Call<List<ItemItem>>
}