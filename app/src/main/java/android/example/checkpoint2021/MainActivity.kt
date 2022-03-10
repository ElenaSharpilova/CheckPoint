package android.example.checkpoint2021

import android.example.checkpoint2021.api.RetrofitInstance
import android.example.checkpoint2021.databinding.ActivityMainBinding
import android.example.checkpoint2021.viewmodel.MyViewModel
import android.example.checkpoint2021.viewmodel.MyViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import repository.MyRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MyViewModel
    private val retrofitService = RetrofitInstance.getInstance()
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MyAdapter()

        viewModel = ViewModelProvider(this, MyViewModelFactory(MyRepository(retrofitService)))
            .get(MyViewModel::class.java)

        var recyclerView = binding.myRV
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.itemList.observe(this, Observer {

            adapter.setItem(it)
        })

        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllItems()
    }
}