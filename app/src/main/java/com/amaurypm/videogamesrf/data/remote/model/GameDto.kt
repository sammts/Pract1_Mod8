package com.amaurypm.videogamesrf.data.remote.model

import com.google.gson.annotations.SerializedName

//En esta clase colocamos los nombres tal cual estan en el JSON
data class GameDto(
    @SerializedName("id")//Aqui ya se está definiendo qué va a leer
    var id: String? = null,//El nombre de las var pueden ser diferentes
    @SerializedName("thumbnail")
    var thumbnail: String? = null,
    @SerializedName("title")
    var title: String? = null
)
