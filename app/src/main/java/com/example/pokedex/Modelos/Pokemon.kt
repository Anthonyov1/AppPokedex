package com.example.pokedex.Modelos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Pokemon(

    @SerializedName("desc")
 @Expose

 val desc: String? = null,

    @SerializedName("id")
 @Expose

 val id: Int? = null,
    @SerializedName("num")
 @Expose
 val num: String? = null,

    @SerializedName("name")
 @Expose
 val nome: String? = null,

    @SerializedName("img")
 @Expose
 val img: String? = null,

    @SerializedName("type")
 @Expose
 val tipo: List<String>? = null,

    @SerializedName("height")
 @Expose
 val tamanho: String? = null,

    @SerializedName("weight")
 @Expose
 val peso: String? = null,

    @SerializedName("weaknesses")
 @Expose
 val fraqueza: List<String>? = null,

    @SerializedName("next_evolution")
 @Expose
 val Evolucao: List<Evolucao>? = null,

    @SerializedName("prev_evolution")
 @Expose
 val preEvolucao: List<preEvolucao>? = null

)
