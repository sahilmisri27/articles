package com.sahil.articles.network.paging

import androidx.paging.DataSource
import com.sahil.articles.db.entity.Article
import rx.subjects.ReplaySubject


/**
 * Created by sm28092 on 26/07/2020
 */
class ArticleNetworkDataSourceFactory : DataSource.Factory<Int, Article>() {
    private var articlePageKeyedDataSource: ArticleNetworkDataSource = ArticleNetworkDataSource()


    override fun create(): DataSource<Int, Article> {
        return articlePageKeyedDataSource
    }


    fun getArticle(): ReplaySubject<Article> {
        return articlePageKeyedDataSource.getArticle()
    }
}