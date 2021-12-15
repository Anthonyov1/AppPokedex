package com.example.pokedex.Modelos
import com.google.gson.annotations.SerializedName


data class PokemonResponse (
    @SerializedName("pokemon")
    val pokemons: List<Pokemon>? = null
)