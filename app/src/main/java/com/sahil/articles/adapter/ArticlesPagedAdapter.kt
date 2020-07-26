package com.sahil.articles.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sahil.articles.R
import com.sahil.articles.model.Article

/**
 * Created by sm28092 on 25/07/2020
 */
class ArticlesPagedAdapter constructor(context: Context?) :
    PagedListAdapter<Article, ArticlesPagedAdapter.ViewHolder>(ARTICLE_COMPARATOR) {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.articles_adapter_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = getItem(position)
        if (article != null) {
            val user = article.user?.get(0)
            holder.userName.text =
                StringBuilder().append(user?.name).append(" ").append(user?.lastName).toString()
            holder.userDesignation.text = user?.designation
            holder.content.text = article.content
            val mediaList = article.media
            if (mediaList != null && mediaList?.isNotEmpty()) {
                val media = article.media?.get(0)
                holder.title.visibility = View.VISIBLE
                holder.url.visibility = View.VISIBLE
                holder.title.text = media?.title
                holder.url.text = media?.url
            } else {
                holder.title.visibility = View.GONE
                holder.url.visibility = View.GONE
            }
            holder.like.text = article.likes.toString()
            holder.comment.text = article.comments.toString()
        }

    }


    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val userAvatar: ImageView = view.findViewById(R.id.userAvatar)
        val userName: TextView = view.findViewById(R.id.userName)
        val userDesignation: TextView = view.findViewById(R.id.userDesignation)
        val articleImage: ImageView = view.findViewById(R.id.articleImage)
        val content: TextView = view.findViewById(R.id.content)
        val title: TextView = view.findViewById(R.id.title)
        val url: TextView = view.findViewById(R.id.url)
        val like: TextView = view.findViewById(R.id.like)
        val comment: TextView = view.findViewById(R.id.comment)
    }

    companion object {
        private val ARTICLE_COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.id == newItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                newItem == oldItem
        }
    }
}