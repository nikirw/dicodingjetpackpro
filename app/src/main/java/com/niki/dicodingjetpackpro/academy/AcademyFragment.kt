package com.niki.dicodingjetpackpro.academy


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_academy.*


/**
 * A simple [Fragment] subclass.
 */
class AcademyFragment : Fragment() {

    private lateinit var academyAdapter: AcademyAdapter

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
            academyAdapter = AcademyAdapter()
            academyAdapter.setListCourses(DataDummy.generateDummyCourses())
            rv_academy.setLayoutManager(LinearLayoutManager(getContext()))
            rv_academy.setHasFixedSize(true)
            rv_academy.setAdapter(academyAdapter)
        }
    }


}
