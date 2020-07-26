package com.sahil.articles.di

import com.sahil.articles.repository.ArticlesRepository
import com.sahil.articles.viewmodel.ArticlesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by sm28092 on 25/07/2020
 */

val uiModule = module {
//    factory { ArticlesAdapter(get()) }
    viewModel { ArticlesViewModel(get()) }
}

val repositoryModule = module {
    single { ArticlesRepository(get()) }
}