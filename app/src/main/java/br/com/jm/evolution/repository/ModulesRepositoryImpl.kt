package br.com.jm.evolution.repository

import android.util.Log
import br.com.jm.evolution.data.entities.ModuleEntity
import com.google.firebase.firestore.FirebaseFirestore

class ModulesRepositoryImpl(
    private val db: FirebaseFirestore
): ModulesRepository {
    override fun getModule(): ModuleEntity {
        db.collection(MODULE_ENTITY_NAME)
            .get()
            .addOnSuccessListener { result ->
                println(result)
            }
            .addOnFailureListener { exception ->
                Log.w("", "Error to get modules", exception)
            }

        return ModuleEntity(
            "",
            "",
            false
        )
    }

    companion object {
        private const val MODULE_ENTITY_NAME = "modules"
    }
}