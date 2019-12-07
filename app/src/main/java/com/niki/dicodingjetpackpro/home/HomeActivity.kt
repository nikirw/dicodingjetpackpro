package com.niki.dicodingjetpackpro.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.academy.AcademyFragment
import com.niki.dicodingjetpackpro.bookmark.BookmarkFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private val SELECTED_MENU = "selected_menu"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var fragment: Fragment = AcademyFragment.newInstance()
        setFragment(fragment)
        nav_view.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.action_home -> {
                    fragment = AcademyFragment.newInstance()
                }
                R.id.action_bookmark -> {
                    fragment = BookmarkFragment.newInstance()
                }
            }
            setFragment(fragment)
            false
        }

        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU);
        } else {
            nav_view.setSelectedItemId(R.id.action_home);
        }
    }

    private fun setFragment(f: Fragment) {
        if (f != null) {
            supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container, f)
                .commit();
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, nav_view.getSelectedItemId())
    }


}
