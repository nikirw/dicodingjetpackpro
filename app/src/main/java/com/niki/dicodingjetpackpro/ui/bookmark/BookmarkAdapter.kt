package com.niki.dicodingjetpackpro.ui.bookmark

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.data.CourseEntity
import com.niki.dicodingjetpackpro.ui.detail.DetailCourseActivity
import kotlinx.android.synthetic.main.items_bookmark.view.*


class BookmarkAdapter(private val activity: Activity) :
    RecyclerView.Adapter<BookmarkAdapter.AcademyViewHolder>() {

    lateinit var clickListener: (CourseEntity) -> Unit

    private val courses: ArrayList<CourseEntity> = ArrayList()

    fun setListCourses(courses: Collection<CourseEntity>) {
        if (courses == null) return
        this.courses.clear()
        this.courses.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcademyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.items_bookmark, parent, false)
        return AcademyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AcademyViewHolder, position: Int) {
        val course = courses[position]
        var view = holder.itemView
        view.tv_item_title.text = course.title
        view.tv_item_date.text = String.format("Deadline %s", course.deadline)
        view.tv_item_description.text = course.description
        holder.itemView.setOnClickListener { v: View? ->
            val intent = Intent(activity, DetailCourseActivity::class.java)
            intent.putExtra(DetailCourseActivity.EXTRA_COURSE, course.courseId)
            activity.startActivity(intent)
        }
        view.img_share.setOnClickListener {
            clickListener(course)
        }
        Glide.with(holder.itemView.context)
            .load(course.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(view.img_poster)
    }

    internal fun setOnClickListener(listener: (CourseEntity) -> Unit) {
        this.clickListener = listener
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    inner class AcademyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)
}