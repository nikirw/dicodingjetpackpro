package com.niki.dicodingjetpackpro.ui.academy

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


class AcademyViewModelTest {
    lateinit var viewModel: AcademyViewModel

    @Before
    fun setUp() {
        viewModel = AcademyViewModel()
    }

    @Test
    fun getCourses() {
        val courseEntities = viewModel.courses
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}