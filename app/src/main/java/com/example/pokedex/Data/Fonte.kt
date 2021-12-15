package com.example.pokedex.Data

import android.content.Context
import android.util.Log
import com.example.pokedex.Modelos.PokemonResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Fonte() {

    // analisa o arquivo json, converte-o em Gson e retorna um objeto PokemonResponse (que consiste em uma lista de objetos Pokémon)
    // lê o arquivo json como uma resposta de API com GSON e o converte em um objeto Pokémon
    fun gsonFromJson(context: Context, filename: String): PokemonResponse {
        val parser = ParseUtils()
        val jsonFileString = parser.parseFromJson(context, filename) ?: "error while parsing"
        Log.d("pokedex", jsonFileString)
        val gson = Gson()
        val pokemonTypeToken = object : TypeToken<PokemonResponse>() {}.type

        return gson.fromJson(jsonFileString, pokemonTypeToken)
    }
}
