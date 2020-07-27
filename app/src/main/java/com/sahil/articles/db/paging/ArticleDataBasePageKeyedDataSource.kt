package com.sahil.articles.db.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.sahil.articles.db.ArticleDao
import com.sahil.articles.db.entity.Article

/**
 * Created by sm28092 on 26/07/2020
 */
class ArticleDataBasePageKeyedDataSource(private val articleDao: ArticleDao) :
    PageKeyedDataSource<String, Article>() {
    override fun loadInitial(params: LoadInitialParams<String>,
                             callback: LoadInitialCallback<String, Article>) {
        Log.i(TAG,
            "Loading Initial Rang, Count " + params.requestedLoadSize)
        val articles: List<Article> = articleDao.getArticles()
        if (articles.isNotEmpty()) {
            callback.onResult(articles, "0", "1")
        }
    }

    override fun loadAfter(params: LoadParams<String>,
                           callback: LoadCallback<String, Article>) {
    }

    override fun loadBefore(params: LoadParams<String>,
                            callback: LoadCallback<String, Article>) {
    }

    companion object {
        val TAG = ArticleDataBasePageKeyedDataSource::class.java.simpleName
    }

}