package com.sahil.articles.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sahil.articles.model.Article
import com.sahil.articles.model.Media
import com.sahil.articles.model.User


/**
 * Created by sm28092 on 25/07/2020
 */
class ArticlesViewModel(context: Context) : ViewModel() {
    private var articleLiveData: MutableLiveData<List<Article>> = MutableLiveData<List<Article>>()

    fun getAllArticles(): LiveData<List<Article>> {
        return getDummyData()
    }

    private fun getDummyData(): LiveData<List<Article>> {
        loadDummyData()
        return articleLiveData
    }

    private fun loadDummyData() {
        val articleList: MutableList<Article> = ArrayList()
        val media: Media = Media("1", "1", "", "", "Title", "URL")
        val mediaList = ArrayList<Media>()
        mediaList.add(media)
        val user: User = User("1", "1", "", "Sahil", "", "Misri", "Pune", "Engineer", "")
        val userList = ArrayList<User>()
        userList.add(user)
        val article: Article = Article("1", "", "Some content", 1000, 2000, mediaList, userList)
        articleList.add(article)
        articleList.add(article)
        articleList.add(article)
        articleList.add(article)
        articleList.add(article)
        articleList.add(article)
        articleList.add(article)
        articleLiveData.value = articleList
    }
}