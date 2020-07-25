package com.sahil.articles.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sahil.articles.R
import com.sahil.articles.util.FragmentUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentUtil.addFragmentToActivity(ArticlesFragment(), supportFragmentManager)
    }
}