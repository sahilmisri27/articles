package com.sahil.articles.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sahil.articles.db.paging.ArticleDataBaseDataSourceFactory
import com.sahil.articles.model.Article
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by sm28092 on 25/07/2020
 */
@Database(entities = [Article::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
    private lateinit var articlePaged: LiveData<PagedList<Article>>
    private val EXECUTOR_THREAD_COUNT = 5

    companion object {
        private var instance: ArticleDatabase? = null
        private const val deviceDatabaseName: String = "articles_database"

        fun getInstance(context: Context): ArticleDatabase {
            if (instance == null) {
                synchronized(ArticleDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        ArticleDatabase::class.java,
                        deviceDatabaseName)
                        .fallbackToDestructiveMigration()
                        .build()
                    instance?.initialize()
                }
            }
            return instance!!
        }
    }

    fun initialize() {
        val pagedListConfig =
            PagedList.Config.Builder().setEnablePlaceholders(false)
                .setInitialLoadSizeHint(Int.MAX_VALUE)
                .setPageSize(Int.MAX_VALUE).build()
        val executor: Executor =
            Executors.newFixedThreadPool(EXECUTOR_THREAD_COUNT)
        val dataSourceFactory =
            ArticleDataBaseDataSourceFactory(
                articleDao())
        val livePagedListBuilder: LivePagedListBuilder<String, Article> =
            LivePagedListBuilder(dataSourceFactory, pagedListConfig)
        articlePaged =
            livePagedListBuilder.setFetchExecutor(executor).build()
    }

    open fun getArticles(): LiveData<PagedList<Article>> {
        return articlePaged
    }
}