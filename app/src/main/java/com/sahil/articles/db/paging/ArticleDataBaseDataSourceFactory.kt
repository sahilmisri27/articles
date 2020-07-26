package com.sahil.articles.db.paging

import androidx.paging.DataSource
import com.sahil.articles.db.ArticleDao
import com.sahil.articles.model.Article

/**
 * Created by sm28092 on 26/07/2020
 */
class ArticleDataBaseDataSourceFactory(dao: ArticleDao) :
    DataSource.Factory<String, Article>() {
    private val articlePageKeyedDataSource: ArticleDataBasePageKeyedDataSource =
        ArticleDataBasePageKeyedDataSource(dao)

    override fun create(): DataSource<String, Article> {
        return articlePageKeyedDataSource
    }

}