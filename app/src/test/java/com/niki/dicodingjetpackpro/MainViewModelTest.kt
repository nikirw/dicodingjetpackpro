package com.niki.dicodingjetpackpro

import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException


class MainViewModelTest {

    lateinit var viewModel: MainViewModel

    @Before
    fun init() {
        viewModel = MainViewModel()
    }

    @Test
    fun calculate() {
        val width = "1"
        val length = "2"
        val height = "3"
        viewModel.calculate(width, height, length)
        Assert.assertEquals(6, viewModel.result)
    }
}