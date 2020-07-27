package com.sahil.articles.db.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sahil.articles.db.entity.Media

/**
 * Created by sm28092 on 26/07/2020
 */
class DataTypeConverterForMedia {
    private val gson = Gson()

    @TypeConverter
    fun stringToList(data: String): List<Media> {
        if (data == null) {
            return emptyList()
        }
        val listType = object :
            TypeToken<List<Media>>() {}.type
        return gson.fromJson(
            data,
            listType)
    }

    @TypeConverter
    fun ListToString(someObjects: List<Media>): String {
        return gson.toJson(someObjects)
    }
}