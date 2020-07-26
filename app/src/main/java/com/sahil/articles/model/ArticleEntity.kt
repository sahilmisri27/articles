package com.sahil.articles.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by sm28092 on 26/07/2020
 */
@Entity(tableName = "article")
class ArticleEntity(
    @PrimaryKey
    val id: String,
    val createdAt: String,
    val content: String,
    val comments: Long,
    val likes: Long,
    val blogId: String,
    val image: String,
    val title: String,
    val url: String,
    val name: String,
    val avatar: String,
    val lastName: String,
    val city: String,
    val designation: String,
    val about: String)