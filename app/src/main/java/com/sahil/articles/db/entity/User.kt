package com.sahil.articles.db.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by sm28092 on 25/07/2020
 */
data class User (
    val id: String,
    val blogId: String,
    val createdAt: String,
    val name: String,
    val avatar: String,
    @SerializedName("lastname")
    val lastName: String,
    val city: String,
    val designation: String,
    val about: String
)