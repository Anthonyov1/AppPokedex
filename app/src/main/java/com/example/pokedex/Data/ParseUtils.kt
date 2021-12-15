package com.example.pokedex.Data

import android.content.Context
import java.lang.Exception


class ParseUtils {

    //parses the Json file, this function is later utilized by the gsonFromJson function
    fun parseFromJson(context: Context, fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use {reader -> reader.readText() }
        } catch (exception: Exception) {
            exception.printStackTrace()
            null
        }

    }
}