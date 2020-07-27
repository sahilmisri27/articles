package com.sahil.articles.network

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PagedList.BoundaryCallback
import com.sahil.articles.db.entity.Article
import com.sahil.articles.network.paging.ArticleNetworkDataSource
import com.sahil.articles.network.paging.ArticleNetworkDataSourceFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by sm28092 on 26/07/2020
 */
class ArticleService(dataSourceFactory: ArticleNetworkDataSourceFactory,
                     boundaryCallback: BoundaryCallback<Article>) {
    val pagedArticles: LiveData<PagedList<Article>>
    private val EXECUTOR_THREAD_COUNT = 5

    companion object {
        private val TAG = ArticleService::class.java.simpleName
    }

    init {
        val pagedListConfig =
            PagedList.Config.Builder().setEnablePlaceholders(false)
                .setInitialLoadSizeHint(ArticleNetworkDataSource.PAGE_SIZE)
                .setPageSize(ArticleNetworkDataSource.PAGE_SIZE).build()
        val executor: Executor =
            Executors.newFixedThreadPool(EXECUTOR_THREAD_COUNT)
        val livePagedListBuilder: LivePagedListBuilder<Int, Article> =
            LivePagedListBuilder(dataSourceFactory, pagedListConfig)
        pagedArticles =
            livePagedListBuilder.setFetchExecutor(executor).setBoundaryCallback(boundaryCallback)
                .build()
    }
}