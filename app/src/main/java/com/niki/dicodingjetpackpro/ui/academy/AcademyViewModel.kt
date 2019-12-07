package com.niki.dicodingjetpackpro.ui.academy

import androidx.lifecycle.ViewModel
import com.niki.dicodingjetpackpro.data.CourseEntity
import com.niki.dicodingjetpackpro.utils.DataDummy


class AcademyViewModel : ViewModel() {
    val courses: List<CourseEntity>
        get() = DataDummy.generateDummyCourses()
}