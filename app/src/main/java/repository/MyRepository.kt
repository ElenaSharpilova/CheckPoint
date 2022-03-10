package repository

import android.example.checkpoint2021.api.ServiceAPI

class MyRepository constructor(private val serviceAPI: ServiceAPI) {

    fun getAllItems() = serviceAPI.getAllItems()
}