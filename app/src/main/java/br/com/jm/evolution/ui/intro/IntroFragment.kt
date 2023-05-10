package br.com.jm.evolution.ui.intro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.jm.evolution.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {
    private val binding: FragmentIntroBinding by lazy {
        FragmentIntroBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupComponents()
    }

    private fun setupComponents() {
        binding.welcomeButton.setOnClickListener {
            //TODO CALL NAVIGATION FUNCTION WHEN CREATED
        }
    }
}