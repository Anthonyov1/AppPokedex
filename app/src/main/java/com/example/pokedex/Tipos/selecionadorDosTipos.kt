package com.example.pokedex.Tipos

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.pokedex.R

object selecionadorDosTipos {
    fun typeSelector(context: Context, type: String?): Drawable? {

        when (type) {

            "Rock" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.rock) }
            }
            "Bug" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.bug) }
            }
            "Ground" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.ground) }
            }
            "Fire" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.fire) }
            }
            "Water" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.water) }
            }
            "Ghost" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.ghost) }
            }
            "Dragon" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.dragon) }
            }
            "Psychic" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.psychc) }
            }
            "Electric" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.electr) }
            }
            "Fighting" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.fight) }
            }
            "Flying" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.flying) }
            }
            "Grass" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.grass) }
            }
            "Normal" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.normal) }
            }
            "Poison" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.poison) }
            }
            "Ice" -> {
                return context.let { ContextCompat.getDrawable(it, R.drawable.ice) }
            }
            else -> return null
        }

    }
}