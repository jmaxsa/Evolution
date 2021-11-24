package br.com.jm.evolution

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.jm.evolution.modules.Module
import br.com.jm.evolution.modules.ModuleListAdapter

class ModulesListActivity: AppCompatActivity(R.layout.activity_modules_list) {

    private val moduleAdapter by lazy { ModuleListAdapter(this) }
    private val rvModules: RecyclerView by lazy { findViewById(R.id.modules_list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rvModules.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rvModules.adapter = moduleAdapter

        //TODO Update to receive a list of real components and redirect to real activity
        val module1 = Module("Bottom Navigation", MainActivity::class.java)
        moduleAdapter.setData(listOf(module1))
    }
}