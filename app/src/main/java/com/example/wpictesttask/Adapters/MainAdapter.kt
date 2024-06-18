package com.example.wpictesttask.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wpictesttask.DataItemTypes
import com.example.wpictesttask.databinding.ItemContentBinding
import com.example.wpictesttask.databinding.ItemFooterBinding
import com.example.wpictesttask.databinding.ItemHeaderBinding

class MainAdapter(private val mList: List<DataItemTypes>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemHeaderViewHolder(private val binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    inner class ItemContentViewHolder(private val binding: ItemContentBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    inner class ItemFooterViewHolder(private val binding: ItemFooterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataItemTypes.ItemFooter) {
            val gridAdapter = GridAdapter(item.imageResIds)
            binding.staggeredGridRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            binding.staggeredGridRecyclerView.adapter = gridAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            ITEM_HEADER_LAYOUT -> {
                val binding = ItemHeaderBinding.inflate(inflater, parent, false)
                ItemHeaderViewHolder(binding)
            }
            ITEM_CONTENT_LAYOUT -> {
                val binding = ItemContentBinding.inflate(inflater, parent, false)
                ItemContentViewHolder(binding)
            }
            ITEM_FOOTER -> {
                val binding = ItemFooterBinding.inflate(inflater, parent, false)
                ItemFooterViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = mList[position]) {
            is DataItemTypes.ItemHeaderLayout -> {
            }
            is DataItemTypes.ItemContentLayout -> {
            }
            is DataItemTypes.ItemFooter -> {
                (holder as ItemFooterViewHolder).bind(item)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (mList[position]) {
            is DataItemTypes.ItemHeaderLayout -> ITEM_HEADER_LAYOUT
            is DataItemTypes.ItemContentLayout -> ITEM_CONTENT_LAYOUT
            is DataItemTypes.ItemFooter -> ITEM_FOOTER
        }
    }

    companion object {
        private const val ITEM_HEADER_LAYOUT = 0
        private const val ITEM_CONTENT_LAYOUT = 1
        private const val ITEM_FOOTER = 2
    }
}
