package android.example.checkpoint2021.viewmodel

import android.example.checkpoint2021.model.ItemItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import repository.MyRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel constructor(private val repository: MyRepository) : ViewModel() {

    val itemList = MutableLiveData<List<ItemItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllItems() {

        val response = repository.getAllItems()
        response.enqueue(object : Callback<List<ItemItem>> {
            override fun onResponse(call: Call<List<ItemItem>>, response: Response<List<ItemItem>>) {
                itemList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<ItemItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}