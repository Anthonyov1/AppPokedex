package com.example.pokedex.Tipos

import android.content.Context
import com.example.pokedex.R

object coresDosTipos {

    fun typeColor(context: Context, type: String?): Int? {

        when (type) {

            "Rock" -> {
                return R.color.rock
            }
            "Bug" -> {
                return R.color.bug
            }
            "Ground" -> {
                return R.color.ground
            }
            "Fire" -> {
                return R.color.fire
            }
            "Water" -> {
                return R.color.water
            }
            "Ghost" -> {
                return R.color.ghost
            }
            "Dragon" -> {
                return R.color.dragon
            }
            "Psychic" -> {
                return R.color.psychic
            }
            "Electric" -> {
                return R.color.electric
            }
            "Fighting" -> {
                return R.color.fight
            }
            "Flying" -> {
                return R.color.flying
            }
            "Grass" -> {
                return R.color.grass
            }
            "Normal" -> {
                return R.color.normal
            }
            "Poison" -> {
                return R.color.poison
            }
            "Ice" -> {
                return R.color.ice
            }
            else -> return null
        }
    }
}