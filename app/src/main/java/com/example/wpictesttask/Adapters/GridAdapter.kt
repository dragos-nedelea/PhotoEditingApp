package com.example.wpictesttask.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wpictesttask.databinding.ItemGridImageBinding
import com.example.wpictesttask.databinding.ItemLastGridImageBinding

class GridAdapter(private val imageResIds: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_NORMAL = 1
    private val VIEW_TYPE_SPAN_TWO = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val binding = ItemGridImageBinding.inflate(inflater, parent, false)
                NormalViewHolder(binding)
            }
            VIEW_TYPE_SPAN_TWO -> {
                val binding = ItemLastGridImageBinding.inflate(inflater, parent, false)
                SpanTwoViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NormalViewHolder -> holder.bind(imageResIds[position])
            is SpanTwoViewHolder -> holder.bind(imageResIds[position])
        }
    }

    override fun getItemCount(): Int {
        return imageResIds.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == imageResIds.size - 1) {
            VIEW_TYPE_SPAN_TWO
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    inner class NormalViewHolder(private val binding: ItemGridImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageResId: Int) {
            binding.imageView.setImageResource(imageResId)
        }
    }

    inner class SpanTwoViewHolder(private val binding: ItemLastGridImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageResId: Int) {
            binding.imageView.setImageResource(imageResId)
        }
    }
}
