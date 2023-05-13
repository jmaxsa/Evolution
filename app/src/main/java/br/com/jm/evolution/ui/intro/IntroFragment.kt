package br.com.jm.evolution.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import br.com.jm.evolution.R
import br.com.jm.evolution.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {
    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupComponents()
    }

    private fun setupComponents() {
        binding.welcomeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_introFragment_to_chooseCategoryFragment)
        }
    }
}