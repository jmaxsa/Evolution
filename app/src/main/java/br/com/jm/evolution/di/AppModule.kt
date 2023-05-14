package br.com.jm.evolution.di

import br.com.jm.evolution.modules.ModuleListViewModel
import br.com.jm.evolution.repository.ModulesRepository
import br.com.jm.evolution.repository.ModulesRepositoryImpl
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule {
    val dbModule = module {
        single { Firebase.firestore }
    }

    val repositories = module {
        single<ModulesRepository> { ModulesRepositoryImpl(get()) }
    }

    val viewModels = module {
        viewModel { ModuleListViewModel(get()) }
    }
}