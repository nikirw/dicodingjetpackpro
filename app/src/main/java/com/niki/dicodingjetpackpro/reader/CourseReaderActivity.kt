package com.niki.dicodingjetpackpro.reader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.reader.content.ModuleContentFragment
import com.niki.dicodingjetpackpro.reader.list.ModuleListFragment


class CourseReaderActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COURSE_ID = "extra_course_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_reader)
        val bundle = intent.extras
        if (bundle != null) {
            val courseId = bundle.getString(EXTRA_COURSE_ID)
            if (courseId != null) {
                populateFragment()
            }
        }
    }

    fun moveTo(position: Int, moduleId: String) {
        var fragment: Fragment = ModuleContentFragment.newInstance()
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, fragment, ModuleContentFragment.TAG)
            .addToBackStack(null)
            .commit();
    }

    override fun onSupportNavigateUp(): Boolean {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish();
        } else {
            onBackPressed()
        }
        return true
    }

    private fun populateFragment() {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(ModuleListFragment.TAG)
        if (fragment == null) {
            fragment = ModuleListFragment.newInstance()
            fragmentTransaction.add(R.id.frame_container, fragment, ModuleListFragment.TAG)
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }
}
