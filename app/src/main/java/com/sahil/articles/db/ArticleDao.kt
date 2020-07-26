package com.sahil.articles.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sahil.articles.model.Article

/**
 * Created by sm28092 on 25/07/2020
 */
@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getArticles(): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(Article: Article)

}