package br.com.jm.evolution.modules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.jm.evolution.MainActivity
import br.com.jm.evolution.R
import br.com.jm.evolution.databinding.FragmentModulesListBinding

class ModulesListFragment : Fragment() {
    private val binding: FragmentModulesListBinding by lazy {
        FragmentModulesListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_modules_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val adapter = ModuleListAdapter(requireContext())
        binding.modulesList.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.modulesList.adapter = adapter

        //TODO Update to receive a list of real components and redirect to real activity
        adapter.setData(
            listOf(
                Module(
                    title = "Bottom Navigation",
                    screen = MainActivity::class.java
                )
            )
        )
    }
}