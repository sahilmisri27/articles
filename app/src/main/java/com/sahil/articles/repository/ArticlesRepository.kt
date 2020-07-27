package com.sahil.articles.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PagedList.BoundaryCallback
import com.sahil.articles.db.ArticleDatabase
import com.sahil.articles.db.entity.Article
import com.sahil.articles.network.ArticleService
import com.sahil.articles.network.paging.ArticleNetworkDataSourceFactory
import rx.schedulers.Schedulers


/**
 * Created by sm28092 on 25/07/2020
 */
class ArticlesRepository(context: Context) {
    private var network: ArticleService
    private var database: ArticleDatabase
    private var liveDataMerger: MediatorLiveData<PagedList<Article>> =
        MediatorLiveData()

    init {
        val dataSourceFactory = ArticleNetworkDataSourceFactory()

        database = ArticleDatabase.getInstance(context.getApplicationContext())

        val boundaryCallback: BoundaryCallback<Article> = object : BoundaryCallback<Article>() {
            override fun onZeroItemsLoaded() {
                super.onZeroItemsLoaded()
                liveDataMerger.addSource(database.getArticles()
                ) { value: Any ->
                    liveDataMerger.setValue(value as PagedList<Article>?)
                    liveDataMerger.removeSource(database.getArticles())
                }
            }
        }

        network = ArticleService(dataSourceFactory, boundaryCallback)

        liveDataMerger.addSource(network.pagedArticles,
            Observer { value: Any ->
                liveDataMerger.setValue(value as PagedList<Article>?)
            })

        dataSourceFactory.getArticle().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe { article ->
                database.articleDao().insertArticle(article)
            }
    }

    fun getArticles(): LiveData<PagedList<Article>> {
        return liveDataMerger
    }

}