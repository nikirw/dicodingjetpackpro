package com.niki.dicodingjetpackpro.reader.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niki.dicodingjetpackpro.R
import com.niki.dicodingjetpackpro.data.ModuleEntity
import kotlinx.android.synthetic.main.items_module_list_custom.view.*


class ModuleListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var clickListener: (Int, String) -> Unit

    private val modules: MutableList<ModuleEntity> = ArrayList()
    fun setModules(modules: Collection<ModuleEntity>) {
        if (modules == null) return
        this.modules.clear()
        this.modules.addAll(modules)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return ModuleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_module_list_custom, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        var view = viewHolder.itemView
        val module = modules[position]
        val moduleViewHolder = viewHolder as ModuleViewHolder
        view.text_module_title.text = module.title
        moduleViewHolder.itemView.setOnClickListener { v: View? ->
            clickListener(viewHolder.adapterPosition, modules.get(moduleViewHolder.adapterPosition).moduleId)
        }
    }

    internal fun setOnClickListener(listener: (Int, String) -> Unit) {
        this.clickListener = listener
    }

    override fun getItemCount(): Int {
        return modules.size
    }

    internal inner class ModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}