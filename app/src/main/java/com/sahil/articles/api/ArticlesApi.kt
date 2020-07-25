package com.sahil.articles.api

import com.sahil.articles.model.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by sm28092 on 25/07/2020
 */
interface ArticlesApi {
    @GET("blogs")
    fun getArticles(@Query("page") page: Int,
                    @Query("limit") limit: Int): Call<List<Article>>
}