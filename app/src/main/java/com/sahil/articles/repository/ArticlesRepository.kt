package com.sahil.articles.repository

import androidx.lifecycle.MutableLiveData
import com.sahil.articles.api.ArticlesApi
import com.sahil.articles.model.Article
import com.sahil.articles.service.RetrofitService.createService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by sm28092 on 25/07/2020
 */
class ArticlesRepository {

    private val articlesApi: ArticlesApi = createService(ArticlesApi::class.java)

    fun getArticles(page: Int, limit: Int): MutableLiveData<List<Article>> {
        val articles = MutableLiveData<List<Article>>()
        articlesApi.getArticles(page,limit).enqueue(object : Callback<List<Article>> {

            override fun onResponse(call: Call<List<Article>>,
                                    response: Response<List<Article>>) {
                if (response.isSuccessful) {
                    articles.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                articles.value = null
            }
        })
        return articles
    }
}