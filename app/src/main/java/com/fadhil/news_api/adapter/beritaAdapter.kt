package com.fadhil.news_api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fadhil.news_api.databinding.ItemBeritaBinding
import com.fadhil.news_api.model.ItemBerita

//class beritaAdapter {

    class beritaAdapter(val articles : ArrayList<ItemBerita>) : RecyclerView.Adapter<com.fadhil.news_api.adapter.beritaAdapter.BeritaHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaHolder {
            val binding = ItemBeritaBinding.inflate(LayoutInflater.from(parent.context),parent, false
            )
            return BeritaHolder(binding)
        }

        override fun onBindViewHolder(holder: BeritaHolder, position: Int) {
            holder.bind(articles[position])
        }

        override fun getItemCount() = articles.size

//    }

    class BeritaHolder(var binding: ItemBeritaBinding) : RecyclerView.ViewHolder(binding.root
    ) {
        fun bind(get: ItemBerita){
            binding.textViewTitle.text = get.title
            binding.textViewDescription.text = get.description

            Glide.with(itemView.context).load(get.urlToImage).into(binding.imageViewBerita)

        }

    }


}