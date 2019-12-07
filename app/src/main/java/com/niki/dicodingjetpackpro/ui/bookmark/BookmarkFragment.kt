package com.niki.dicodingjetpackpro.ui.bookmark


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.data.CourseEntity
import com.niki.dicodingjetpackpro.utils.DataDummy.generateDummyCourses
import kotlinx.android.synthetic.main.fragment_bookmark.*


/**
 * A simple [Fragment] subclass.
 */
class BookmarkFragment : Fragment() {

    lateinit var adapter: BookmarkAdapter
    lateinit var viewModel: BookmarkViewModel
    lateinit var courses: List<CourseEntity>

    fun BookmarkFragment() {}

    companion object {
        fun newInstance(): BookmarkFragment = BookmarkFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_bookmark, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun onShareClick(course: CourseEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(activity)
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(
                    kotlin.String.format(
                        "Segera daftar kelas %s di dicoding.com",
                        course.title
                    )
                )
                .startChooser()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            viewModel = ViewModelProviders.of(this).get(BookmarkViewModel::class.java)
            courses = viewModel.bookmarks
            adapter = BookmarkAdapter(activity!!)
            adapter.setOnClickListener {
                onShareClick(it)
            }
            adapter.setListCourses(courses)
            rv_bookmark.setLayoutManager(LinearLayoutManager(context))
            rv_bookmark.setHasFixedSize(true)
            rv_bookmark.setAdapter(adapter)
        }
    }

}
