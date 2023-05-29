package br.com.jm.evolution.repository

import androidx.lifecycle.MutableLiveData
import br.com.jm.evolution.FireStoreResponse
import br.com.jm.evolution.data.entities.ModuleEntity

interface ModulesRepository {
    fun getEnableModules(): MutableLiveData<FireStoreResponse<ModuleEntity>>
}