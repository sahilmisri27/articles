package com.sahil.articles.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.sahil.articles.R
import com.sahil.articles.adapter.PagedAdapter
import com.sahil.articles.viewmodel.ArticlesViewModel
import org.koin.android.ext.android.inject


/**
 * Created by sm28092 on 22/07/2020
 */
class ArticlesFragment : BaseFragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var articlesAdapter: PagedAdapter
    private val articleViewModel: ArticlesViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.articles_fragment, container, false)
        articlesAdapter = PagedAdapter(context)
        viewPager = view.findViewById(R.id.articles_view_pager)
        viewPager.adapter = articlesAdapter
        getAdapterData()
        return view
    }

    private fun getAdapterData() {

        articleViewModel.itemPagedList.observe(viewLifecycleOwner, Observer {
            articlesAdapter.submitList(it)
        })
    }
}