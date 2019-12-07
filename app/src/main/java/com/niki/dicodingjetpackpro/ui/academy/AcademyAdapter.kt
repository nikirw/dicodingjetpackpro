package com.niki.dicodingjetpackpro.ui.academy

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.data.CourseEntity
import com.niki.dicodingjetpackpro.ui.detail.DetailCourseActivity
import kotlinx.android.synthetic.main.items_academy.view.*


class AcademyAdapter: RecyclerView.Adapter<AcademyAdapter.AcademyViewHolder>() {

    private lateinit var context: Context
    private val mCourses: MutableList<CourseEntity> = ArrayList()

    private fun getListCourses(): List<CourseEntity?>? {
        return mCourses
    }


    fun setListCourses(listCourses: Collection<CourseEntity>) {
        if (listCourses == null) return
        mCourses.clear()
        mCourses.addAll(listCourses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcademyViewHolder {
        context = parent.context
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items_academy, parent, false)
        return AcademyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AcademyViewHolder,
        position: Int
    ) {
        var view = holder.itemView
        view.tv_item_title.text = getListCourses()!![position]!!.title
        view.tv_item_description.text = getListCourses()!![position]!!.description
        view.tv_item_date.text = String.format(
            "Deadline %s",
            getListCourses()!![position]!!.deadline
        )
        view.setOnClickListener { v: View? ->
            val intent = Intent(context as AppCompatActivity, DetailCourseActivity::class.java)
            intent.putExtra(
                DetailCourseActivity.EXTRA_COURSE,
                getListCourses()!![position]!!.courseId
            )
            (context as AppCompatActivity).startActivity(intent)
        }
        Glide.with(holder.itemView.context)
            .load(getListCourses()!![position]!!.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(view.img_poster)
    }

    override fun getItemCount(): Int {
        return getListCourses()!!.size
    }

    class AcademyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}