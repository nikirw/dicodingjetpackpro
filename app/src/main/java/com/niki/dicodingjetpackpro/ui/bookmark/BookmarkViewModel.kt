package com.niki.dicodingjetpackpro.ui.bookmark

import androidx.lifecycle.ViewModel
import com.niki.dicodingjetpackpro.data.CourseEntity
import com.niki.dicodingjetpackpro.utils.DataDummy

class BookmarkViewModel : ViewModel() {
    val bookmarks: List<CourseEntity>
        get() = DataDummy.generateDummyCourses()
}