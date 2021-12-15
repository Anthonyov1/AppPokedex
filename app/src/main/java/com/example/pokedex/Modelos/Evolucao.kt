package com.example.pokedex.Modelos

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Evolucao {
    @SerializedName("num")
    @Expose
    val evoLevel: String? = null

    @SerializedName("name")
    @Expose
    val nome: String? = null
}