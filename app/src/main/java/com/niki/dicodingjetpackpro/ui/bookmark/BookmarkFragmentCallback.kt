package com.niki.dicodingjetpackpro.ui.bookmark

import com.niki.dicodingjetpackpro.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
