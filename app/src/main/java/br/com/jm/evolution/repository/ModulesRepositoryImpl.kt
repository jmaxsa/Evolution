package br.com.jm.evolution.repository

import androidx.lifecycle.MutableLiveData
import br.com.jm.evolution.FireStoreResponse
import br.com.jm.evolution.data.entities.ModuleEntity
import com.google.firebase.firestore.FirebaseFirestore
class ModulesRepositoryImpl(
    private val db: FirebaseFirestore
): ModulesRepository {
    override fun getEnableModules(): MutableLiveData<FireStoreResponse<ModuleEntity>> {
        val fireStoreResponse = FireStoreResponse<ModuleEntity>()
        val mutableLiveData = MutableLiveData<FireStoreResponse<ModuleEntity>>()
        db.collection(MODULE_ENTITY_NAME)
            .whereEqualTo("isEnable", true)
            .get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    val result = task.result
                    result?.let {
                        fireStoreResponse.response = result.documents.mapNotNull { snapShot ->
                            snapShot.toObject(ModuleEntity::class.java)
                        }
                    }
                } else {
                    fireStoreResponse.exception = task.exception
                }
                mutableLiveData.value = fireStoreResponse
            }
        return mutableLiveData
    }

    companion object {
        private const val MODULE_ENTITY_NAME = "modules"
    }
}