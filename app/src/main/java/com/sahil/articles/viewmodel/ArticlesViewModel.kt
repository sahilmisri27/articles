package com.sahil.articles.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.sahil.articles.model.Article
import com.sahil.articles.repository.ArticlesRepository


/**
 * Created by sm28092 on 25/07/2020
 */
class ArticlesViewModel(application: Application) : AndroidViewModel(application) {

    private var repository:ArticlesRepository = ArticlesRepository(application.applicationContext)

    fun getArticles(): LiveData<PagedList<Article>> {
        return repository.getArticles()
    }

}