package com.example.rayzal_160420103_hobbyapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rayzal_160420103_hobbyapp.databinding.FragmentNewsAdapterBinding
import com.example.rayzal_160420103_hobbyapp.model.News

class NewsAdapter : ListAdapter<News, NewsAdapter.NewsViewHolder>(NewsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = FragmentNewsAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)

        Glide.with(holder.itemView.context)
            .load(news.imageUrl)
            .into(holder.binding.ivNewsImage)

        holder.binding.btnRead.setOnClickListener {
            onItemClickListener?.invoke(news)
        }
    }

    private var onItemClickListener: ((News) -> Unit)? = null

    fun setOnItemClickListener(listener: (News) -> Unit) {
        onItemClickListener = listener
    }

    inner class NewsViewHolder(val binding: FragmentNewsAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(news: News) {
            binding.tvTitle.text = news.title
            binding.tvDescription.text = news.description
            binding.tvAuthor.text = news.author

        }
    }

    class NewsDiffCallback : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }
    }
}