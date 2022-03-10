package android.example.checkpoint2021.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import repository.MyRepository

class MyViewModelFactory constructor(private val repository: MyRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(MyViewModel::class.java)){
            MyViewModel(this.repository) as T
        } else {
            throw IllegalAccessException("ViewModel Not Found")
        }
    }
}