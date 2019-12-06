package com.niki.dicodingjetpackpro.data

class ModuleEntity(
    var moduleId: String,
    var courseId: String,
    var title: String,
    var position: Int,
    var read: Boolean?
) {
    var contentEntity: ContentEntity? = null
    var isRead = false

    fun setIdCourse(courseId: String) {
        this.courseId = courseId
    }

    init {
        if (read != null) {
            isRead = read as Boolean
        }
    }
}