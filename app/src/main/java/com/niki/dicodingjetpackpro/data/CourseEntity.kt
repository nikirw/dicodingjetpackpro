package com.niki.dicodingjetpackpro.data

class CourseEntity(
    var courseId: String,
    var title: String,
    var description: String,
    var deadline: String,
    var bookmarked: Boolean?,
    imagePath: String
) {
    var isBookmarked = false
    var imagePath: String

    init {
        if (bookmarked != null) isBookmarked = bookmarked as Boolean
        this.imagePath = imagePath
    }
}