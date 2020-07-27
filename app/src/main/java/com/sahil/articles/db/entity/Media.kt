package com.sahil.articles.db.entity

/**
 * Created by sm28092 on 25/07/2020
 */
data class Media (
    val id: String,
    val blogId: String,
    val createdAt: String,
    val image: String,
    val title: String,
    val url: String
)