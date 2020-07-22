package com.sahil.articles.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.sahil.articles.R

/**
 * Created by sm28092 on 22/07/2020
 */
object FragmentUtil {

    /**
     * Adds fragment to container
     *
     * @param fragment the new fragment.
     * @param activity  the application context.
     */
    fun addFragmentToActivity(fragment: Fragment, manager: FragmentManager) {
        val transaction: FragmentTransaction =
            manager.beginTransaction().addToBackStack(fragment.tag)
        transaction.add(R.id.app_main_fragment_container, fragment)
        transaction.commit()
    }
}