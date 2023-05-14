package br.com.jm.evolution

import android.app.Application
import br.com.jm.evolution.di.AppModule.dbModule
import br.com.jm.evolution.di.AppModule.repositories
import br.com.jm.evolution.di.AppModule.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class EvolutionApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@EvolutionApplication)
            modules(listOf(
                dbModule,
                repositories,
                viewModels
            ))
        }
    }
}