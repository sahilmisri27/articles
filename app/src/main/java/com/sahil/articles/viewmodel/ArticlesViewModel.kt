package com.sahil.articles.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.sahil.articles.network.paging.ArticleDataSource
import com.sahil.articles.network.paging.ArticleDataSourceFactory
import com.sahil.articles.model.Article
import com.sahil.articles.repository.ArticlesRepository


/**
 * Created by sm28092 on 25/07/2020
 */
class ArticlesViewModel(context: Context, articlesRepository: ArticlesRepository) : ViewModel() {

    var itemPagedList: LiveData<PagedList<Article>>
    private var liveDataSource: LiveData<PageKeyedDataSource<Int, Article>>

    init {
        val itemDataSourceFactory =
            ArticleDataSourceFactory()
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource()
        val config: PagedList.Config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(ArticleDataSource.PAGE_SIZE)
            .build()
        itemPagedList = LivePagedListBuilder(itemDataSourceFactory, config).build()
    }
}