package com.niki.dicodingjetpackpro.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.data.ModuleEntity


class DetailCourseAdapter :
    RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder>() {
    private val mModules: MutableList<ModuleEntity> = ArrayList()
    fun setModules(modules: Collection<ModuleEntity>) {
        if (modules == null) return
        mModules.clear()
        mModules.addAll(modules)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModuleViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_module_list, parent, false)
        return ModuleViewHolder(view)
    }

    override fun onBindViewHolder(
        viewHolder: ModuleViewHolder,
        position: Int
    ) {
        viewHolder.bind(mModules[position].title)
    }

    override fun getItemCount(): Int {
        return mModules.size
    }

    inner class ModuleViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView
        fun bind(title: String?) {
            textTitle.text = title
        }

        init {
            textTitle = itemView.findViewById(R.id.text_module_title)
        }
    }
}