package br.com.jm.evolution.modules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import br.com.jm.evolution.MainActivity
import br.com.jm.evolution.R
import br.com.jm.evolution.databinding.FragmentModulesListBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ModulesListFragment : Fragment() {
    private var _binding: FragmentModulesListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ModuleListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentModulesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        viewModel.getModules()
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