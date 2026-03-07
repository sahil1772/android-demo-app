package com.example.bugdemo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bugdemo.R
import com.example.bugdemo.data.model.FeedItem

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.FeedViewHolder>() {
    private var items: List<FeedItem> = emptyList()

    fun updateItems(newItems: List<FeedItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.title)
        private val descView: TextView = itemView.findViewById(R.id.description)

        fun bind(item: FeedItem) {
            titleView.text = item.title
            descView.text = item.body
        }
    }
}
