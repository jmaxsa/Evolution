package br.com.jm.evolution.ui.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.jm.evolution.databinding.FragmentChooseCategoryBinding

class ChooseCategoryFragment: Fragment() {
    private val binding: FragmentChooseCategoryBinding by lazy {
        FragmentChooseCategoryBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupComponents()
    }

    private fun setupComponents() {
        binding.componentCategoryButton.setOnClickListener {
            //TODO CALL NAVIGATION FUNCTION WHEN CREATED
        }
    }
}