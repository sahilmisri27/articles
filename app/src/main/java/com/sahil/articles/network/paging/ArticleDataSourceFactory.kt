package com.sahil.articles.network.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.sahil.articles.model.Article


/**
 * Created by sm28092 on 26/07/2020
 */
class ArticleDataSourceFactory : DataSource.Factory<Int, Article>() {
    private val itemLiveDataSource: MutableLiveData<PageKeyedDataSource<Int, Article>> =
        MutableLiveData()

    override fun create(): DataSource<Int, Article> {
        val articleDataSource = ArticleDataSource()
        itemLiveDataSource.postValue(articleDataSource)
        return articleDataSource
    }

    fun getItemLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Article>> {
        return itemLiveDataSource
    }
}