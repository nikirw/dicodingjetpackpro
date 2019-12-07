package com.niki.dicodingjetpackpro.reader.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.data.ModuleEntity
import com.niki.dicodingjetpackpro.reader.CourseReaderActivity
import com.niki.dicodingjetpackpro.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_module_list.*


/**
 * A simple [Fragment] subclass.
 */
class ModuleListFragment : Fragment() {

    lateinit var adapter: ModuleListAdapter
    fun ModuleListFragment() { // Required empty public constructor
    }

    companion object {
        val TAG = ModuleListFragment::class.java.simpleName
        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            adapter = ModuleListAdapter();
            adapter.setOnClickListener { i, s ->
                (activity as CourseReaderActivity).moveTo(i, s)
            }
            populateRecyclerView(DataDummy.generateDummyModules("a14"));
        }
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        progress_bar.setVisibility(View.GONE)
        adapter.setModules(modules)
        rv_module.setLayoutManager(LinearLayoutManager(context))
        rv_module.setHasFixedSize(true)
        rv_module.setAdapter(adapter)
        val dividerItemDecoration =
            DividerItemDecoration(rv_module.getContext(), DividerItemDecoration.VERTICAL)
        rv_module.addItemDecoration(dividerItemDecoration)
    }


}
