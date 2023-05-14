package br.com.jm.evolution.modules

import androidx.lifecycle.ViewModel
import br.com.jm.evolution.repository.ModulesRepository

class ModuleListViewModel(
    private val modulesRepository: ModulesRepository
): ViewModel() {

    fun getModules() {
        modulesRepository.getModule()
    }
}