package com.example.pokedex.Data

import android.content.Context
import android.util.Log
import com.example.pokedex.Modelos.PokemonResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Fonte() {

    // parses the json file, converts it to Gson and returns a PokemonResponse object (which consists of a list o Pokemon objects)
    // read the json file as an API response with GSON and converts it into a Pokemon object
    fun gsonFromJson(context: Context, filename: String): PokemonResponse {
        val parser = ParseUtils()
        val jsonFileString = parser.parseFromJson(context, filename) ?: "error while parsing"
        Log.d("pokedex", jsonFileString)
        val gson = Gson()
        val pokemonTypeToken = object : TypeToken<PokemonResponse>() {}.type

        return gson.fromJson(jsonFileString, pokemonTypeToken)
    }
}
