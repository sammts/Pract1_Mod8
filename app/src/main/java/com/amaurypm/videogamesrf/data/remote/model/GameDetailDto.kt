package com.amaurypm.videogamesrf.data.remote.model

import com.google.gson.annotations.SerializedName

//Información del API con los detalles
data class GameDetailDto(
    @SerializedName("video")
    var video: String? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("age")
    var age: String? = null,
    @SerializedName("parent")
    var parent: String? = null,
    @SerializedName("state")
    var state: String? = null,
    @SerializedName("description")
    var description: String? = null
)
