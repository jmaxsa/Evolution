package br.com.jm.evolution.data.entities

import com.google.firebase.firestore.PropertyName

data class ModuleEntity(
    @PropertyName("title")
    var title: String? = null,
    @PropertyName("screen")
    var screen: String? = null,
    @PropertyName("isEnable")
    var isEnable: Boolean? = null
)