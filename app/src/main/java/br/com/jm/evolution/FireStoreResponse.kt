package br.com.jm.evolution

data class FireStoreResponse<T>(
    var response: List<T>? = null,
    var exception: Exception? = null
)