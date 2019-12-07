package com.niki.dicodingjetpackpro.ui.bookmark

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


class BookmarkViewModelTest {
    lateinit var viewModel: BookmarkViewModel

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmark() {
        val courseEntities = viewModel.bookmarks
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}