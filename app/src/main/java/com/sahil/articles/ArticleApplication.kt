package com.sahil.articles

import android.app.Application
import com.sahil.articles.di.repositoryModule
import com.sahil.articles.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by sm28092 on 25/07/2020
 */
class ArticleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        TODO("FIX ME")
//        startKoin {
//            androidContext(this@ArticleApplication)
//
//            modules(listOf(uiModule, repositoryModule))
//        }
    }
}