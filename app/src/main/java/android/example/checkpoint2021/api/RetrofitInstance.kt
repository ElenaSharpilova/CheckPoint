package android.example.checkpoint2021.api

import android.example.checkpoint2021.util.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {

        var retrofitService: ServiceAPI? = null

        fun getInstance() : ServiceAPI {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ServiceAPI::class.java)
            }
            return retrofitService!!
        }
    }

}