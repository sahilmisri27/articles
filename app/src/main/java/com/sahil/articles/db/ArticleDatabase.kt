package com.sahil.articles.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sahil.articles.model.ArticleEntity

/**
 * Created by sm28092 on 25/07/2020
 */
@Database(entities = [ArticleEntity::class], version = 1)
//@TypeConverters(DataConverter::class)
abstract class ArticleDatabase  : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
    private lateinit var articlePaged: LiveData<PagedList<ArticleEntity>>

    companion object {
        private lateinit var instance: ArticleDatabase
        private const val deviceDatabaseName: String = "articles_database"

        fun getInstance(context: Context): ArticleDatabase {
            if (instance == null) {
                synchronized(ArticleDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        ArticleDatabase::class.java,
                        deviceDatabaseName)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }
    }
}