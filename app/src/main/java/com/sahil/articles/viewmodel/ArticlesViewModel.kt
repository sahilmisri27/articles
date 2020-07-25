package com.sahil.articles.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sahil.articles.model.Article
import com.sahil.articles.repository.ArticlesRepository


/**
 * Created by sm28092 on 25/07/2020
 */
class ArticlesViewModel(context: Context, articlesRepository: ArticlesRepository) : ViewModel() {

    private var articleLiveData: MutableLiveData<List<Article>> = MutableLiveData<List<Article>>()
    private var repository: ArticlesRepository = articlesRepository

    fun getAllArticles(): LiveData<List<Article>> {
        return repository.getArticles(1, 10)
    }
}