package com.niki.dicodingjetpackpro.ui.academy


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.data.CourseEntity
import com.niki.dicodingjetpackpro.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_academy.*


/**
 * A simple [Fragment] subclass.
 */
class AcademyFragment : Fragment() {

    lateinit var academyAdapter: AcademyAdapter
    lateinit var viewModel: AcademyViewModel
    lateinit var courses: List<CourseEntity>

    fun AcademyFragment() {
    }

    companion object {
        fun newInstance(): AcademyFragment = AcademyFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_academy, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity != null) {
            viewModel = ViewModelProviders.of(this).get(AcademyViewModel::class.java)
            courses = viewModel.courses

            academyAdapter = AcademyAdapter()
            academyAdapter.setListCourses(courses)
            rv_academy.setLayoutManager(LinearLayoutManager(getContext()))
            rv_academy.setHasFixedSize(true)
            rv_academy.setAdapter(academyAdapter)
        }
    }


}
