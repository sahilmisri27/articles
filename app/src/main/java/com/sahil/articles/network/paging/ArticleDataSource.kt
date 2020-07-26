package com.sahil.articles.network.paging

import androidx.paging.PageKeyedDataSource
import com.sahil.articles.network.ArticlesApi
import com.sahil.articles.model.Article
import com.sahil.articles.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by sm28092 on 26/07/2020
 */
class ArticleDataSource : PageKeyedDataSource<Int, Article>() {

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
        val service: ArticlesApi = RetrofitService.createService(ArticlesApi::class.java)
        val call = service.getArticles(params.key, 10)
        call.enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val key = if (params.key > 1) params.key - 1 else 0
                    apiResponse?.let {
                        callback.onResult(apiResponse, key)
                    }
                }
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
            }
        })
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int,
            Article>) {
        val service: ArticlesApi = RetrofitService.createService(ArticlesApi::class.java)
        val call = service.getArticles(FIRST_PAGE, 10)
        call.enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    apiResponse?.let {
                        callback.onResult(apiResponse, null, FIRST_PAGE + 1)
                    }
                }
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
        val service: ArticlesApi = RetrofitService.createService(ArticlesApi::class.java)
        val call = service.getArticles(params.key, 10)
        call.enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val key = params.key + 1
                    apiResponse?.let {
                        callback.onResult(apiResponse, key)
                    }
                }
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
            }
        })
    }

    companion object {
        const val PAGE_SIZE = 6
        const val FIRST_PAGE = 1
    }
}