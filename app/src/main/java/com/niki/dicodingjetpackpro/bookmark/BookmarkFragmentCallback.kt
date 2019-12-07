package com.niki.dicodingjetpackpro.bookmark

import com.niki.dicodingjetpackpro.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
