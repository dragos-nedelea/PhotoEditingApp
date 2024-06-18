package com.example.wpictesttask

import com.example.wpictesttask.Adapters.GridAdapter
import com.example.wpictesttask.Adapters.MainAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wpictesttask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private lateinit var gridAdapter: GridAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = createSampleData()
        mainAdapter = MainAdapter(dataList)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = mainAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)



    }
    private fun createSampleData(): List<DataItemTypes> {
        val itemList = mutableListOf<DataItemTypes>().apply {
            add(DataItemTypes.ItemHeaderLayout)
            add(DataItemTypes.ItemContentLayout)
            add(DataItemTypes.ItemFooter(listOf(
                R.drawable.pic1,
                R.drawable.pic2,
                R.drawable.pic3,
                R.drawable.pic4,
                R.drawable.pic5,
                R.drawable.pic6,
                R.drawable.pic7,
                R.drawable.pic8,
                R.drawable.pic9
            )))

        }
        return itemList
    }
    }