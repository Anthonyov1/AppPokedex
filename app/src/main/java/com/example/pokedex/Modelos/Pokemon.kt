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

    @SerializedName("spatk")
 @Expose
 val ataquesp: String? = null,

    @SerializedName("spdef")
 @Expose
 val defesasp: String? = null,

    @SerializedName("hp")
@Expose
    val vida: String? = null,

    @SerializedName("attack")
@Expose
    val ataque: String? = null,

    @SerializedName("defense")
@Expose
    val defesa: String? = null,

    @SerializedName("speed")
@Expose
    val velocidade: String? = null,

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
