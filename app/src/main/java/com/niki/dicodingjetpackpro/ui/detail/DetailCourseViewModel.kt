package com.niki.dicodingjetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.niki.dicodingjetpackpro.data.CourseEntity
import com.niki.dicodingjetpackpro.data.ModuleEntity
import com.niki.dicodingjetpackpro.utils.DataDummy.generateDummyCourses
import com.niki.dicodingjetpackpro.utils.DataDummy.generateDummyModules


class DetailCourseViewModel : ViewModel() {

    private var mCourse: CourseEntity? = null
    private var courseId: String? = null

    fun getCourse(): CourseEntity? {
        for (i in generateDummyCourses().indices) {
            val courseEntity = generateDummyCourses()[i]
            if (courseEntity.courseId == courseId) {
                mCourse = courseEntity
            }
        }
        return mCourse
    }

    fun getModules(): List<ModuleEntity> {
        return generateDummyModules(getCourseId())
    }

    fun setCourseId(courseId: String?) {
        this.courseId = courseId
    }

    fun getCourseId(): String? {
        return courseId
    }

}