package br.com.jm.evolution.repository

import br.com.jm.evolution.data.entities.ModuleEntity

interface ModulesRepository {
    fun getModule(): ModuleEntity
}