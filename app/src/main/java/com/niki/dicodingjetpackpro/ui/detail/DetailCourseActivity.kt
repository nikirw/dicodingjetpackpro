package com.niki.dicodingjetpackpro.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.data.CourseEntity
import com.niki.dicodingjetpackpro.data.ModuleEntity
import com.niki.dicodingjetpackpro.ui.reader.CourseReaderActivity
import com.niki.dicodingjetpackpro.utils.DataDummy
import com.niki.dicodingjetpackpro.utils.DataDummy.getCourse
import kotlinx.android.synthetic.main.activity_detail_course.*
import kotlinx.android.synthetic.main.content_detail_course.*

class DetailCourseActivity : AppCompatActivity() {

    lateinit var adapter: DetailCourseAdapter
    lateinit var viewModel: DetailCourseViewModel
    lateinit var modules: List<ModuleEntity>

    companion object {
        val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_course)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProviders.of(this).get(DetailCourseViewModel::class.java)

        adapter = DetailCourseAdapter()

        var extras = intent.extras
        if(extras != null) {
            var courseId: String? = extras.getString(EXTRA_COURSE)
            if(courseId != null) {
                viewModel.setCourseId(courseId)
                modules = viewModel.getModules()
                adapter.setModules(modules)
            }
        }

        if(viewModel.getCourse() != null) {
            populateCourse(viewModel.getCourse()!!)
        }

        rv_module.setNestedScrollingEnabled(false)
        rv_module.setLayoutManager(LinearLayoutManager(this))
        rv_module.setHasFixedSize(true)
        rv_module.setAdapter(adapter)
        val dividerItemDecoration =
            DividerItemDecoration(rv_module.getContext(), DividerItemDecoration.VERTICAL)
        rv_module.addItemDecoration(dividerItemDecoration)
    }

    fun populateCourse(courseEntity: CourseEntity) {
        text_title.setText(courseEntity!!.title)
        text_desc.setText(courseEntity.description)
        text_date.setText(String.format("Deadline %s", courseEntity.deadline))

        Glide.with(getApplicationContext())
            .load(courseEntity.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(image_poster);

        btn_start.setOnClickListener {v: View ->
            val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, viewModel.getCourseId())
            v.getContext().startActivity(intent)
        }
    }

}
