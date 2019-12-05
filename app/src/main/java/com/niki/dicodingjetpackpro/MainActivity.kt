package com.niki.dicodingjetpackpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        displayResult()

        btn_calculate.setOnClickListener {
            val width: String = edt_width.getText().toString()
            val height: String = edt_height.getText().toString()
            val length: String = edt_length.getText().toString()
            if (width.isEmpty()) {
                edt_width.setError("Masih kosong")
            } else if (height.isEmpty()) {
                edt_height.setError("Masih kosong")
            } else if (length.isEmpty()) {
                edt_length.setError("Masih kosong")
            } else {
                viewModel.calculate(width, height, length)
                displayResult()
            }
        }

    }

    private fun displayResult() {
        tv_result.setText(viewModel.result.toString())
    }
}