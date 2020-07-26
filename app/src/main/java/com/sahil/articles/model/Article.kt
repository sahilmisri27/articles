package com.sahil.articles.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

/**
 * Created by sm28092 on 26/07/2020
 */
@Entity(tableName = "article")
class Article {
    @PrimaryKey()
    var id: String = ""
    var createdAt: String = ""
    var content: String = ""
    var comments: Long = 0
    var likes: Long = 0

    @TypeConverters(DataTypeConverterForMedia::class)
    var media: List<Media>? = null

    @TypeConverters(DataTypeConverterForUser::class)
    var user: List<User>? = null

}