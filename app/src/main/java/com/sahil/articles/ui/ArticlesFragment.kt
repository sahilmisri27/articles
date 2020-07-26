package com.sahil.articles.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.sahil.articles.R
import com.sahil.articles.adapter.ArticlesPagedAdapter
import com.sahil.articles.viewmodel.ArticlesViewModel


/**
 * Created by sm28092 on 22/07/2020
 */
class ArticlesFragment : BaseFragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var articlesAdapter: ArticlesPagedAdapter
    private lateinit var articleViewModel: ArticlesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.articles_fragment, container, false)
        articlesAdapter = ArticlesPagedAdapter(context)
        viewPager = view.findViewById(R.id.articles_view_pager)
        viewPager.adapter = articlesAdapter
        articleViewModel = ViewModelProviders.of(requireActivity()).get(ArticlesViewModel::class.java)
        registerObserver()
        return view
    }

    private fun registerObserver() {
        articleViewModel.getArticles().observe(viewLifecycleOwner, Observer {
            articlesAdapter.submitList(it)
        })
    }
}