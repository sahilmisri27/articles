package com.sahil.articles.db.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sahil.articles.db.entity.User

/**
 * Created by sm28092 on 26/07/2020
 */
class DataTypeConverterForUser {
    private val gson = Gson()

    @TypeConverter
    fun stringToList(data: String): List<User> {
        if (data == null) {
            return emptyList()
        }
        val listType = object :
            TypeToken<List<User>>() {}.type
        return gson.fromJson(
            data,
            listType)
    }

    @TypeConverter
    fun ListToString(someObjects: List<User>): String {
        return gson.toJson(someObjects)
    }
}