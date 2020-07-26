package com.sahil.articles.model

import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by sm28092 on 25/07/2020
 */
data class Article(
    val id: String,
    val createdAt: String,
    val content: String,
    val comments: Long,
    val likes: Long,
    val media: List<Media>,
    val user: List<User>)

