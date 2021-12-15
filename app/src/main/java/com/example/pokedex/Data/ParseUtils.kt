package com.example.pokedex.Data

import android.content.Context
import java.lang.Exception


class ParseUtils {

    //analisa o arquivo Json, esta função é posteriormente utilizada pela função gsonFromJson
    fun parseFromJson(context: Context, fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use {reader -> reader.readText() }
        } catch (exception: Exception) {
            exception.printStackTrace()
            null
        }

    }
}