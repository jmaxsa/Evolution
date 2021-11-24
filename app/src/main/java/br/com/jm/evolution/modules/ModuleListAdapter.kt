package br.com.jm.evolution.modules

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.jm.evolution.R

class ModuleListAdapter(
    private val context: Context
): RecyclerView.Adapter<ModuleViewHolder>() {

    private var modules = emptyList<Module>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_module, parent, false)
        return ModuleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val module = modules[position]
        holder.title.text = module.title
        holder.root.setOnClickListener {
            context.startActivity(Intent(context, module.screen))
        }
    }

    override fun getItemCount(): Int {
        return modules.size
    }

    fun setData(payload: List<Module>) {
        val diffUtil = ModuleDiffUtil(oldList = modules, newList = payload)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        modules = payload
        diffResults.dispatchUpdatesTo(this)
    }
}

class ModuleViewHolder(
    view: View
): RecyclerView.ViewHolder(view) {
    val title: TextView = itemView.findViewById(R.id.module_title)
    val root: ConstraintLayout = itemView.findViewById(R.id.item_root)
}

class ModuleDiffUtil(
    private val oldList: List<Module>,
    private val newList: List<Module>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
