package com.example.pokedex.Adaptador

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.Modelos.Pokemon
import com.example.pokedex.Interface.listagemDosPokemonsDirections
import com.example.pokedex.Tipos.selecionadorDosTipos.typeSelector
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList


class pokemonAdaptador(private val pokemonLista: List<Pokemon>) :

    RecyclerView.Adapter<pokemonAdaptador.ItemViewHolder>(), Filterable {

    /*filtro a barra de pesquisa do Pokémon, a visualização do reciclador sempre retornará os resultados da filtragem,
      exceto quando não há pesquisa, retornando toda a lista */

    var FiltroLista = pokemonLista.toMutableList()
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                FiltroLista = if (charSearch.isEmpty()) {
                    pokemonLista.toMutableList()
                } else {
                    val resultList = ArrayList<Pokemon>()
                    for (row in pokemonLista) {
                        if (row.nome?.toLowerCase(Locale.ROOT)
                                ?.contains(charSearch.toLowerCase(Locale.ROOT)) == true
                        ) {
                            resultList.add(row)
                        } else if(row.num?.contains(charSearch) == true){
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = FiltroLista

                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                FiltroLista = results?.values as MutableList<Pokemon>
                notifyDataSetChanged()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {


        val pokemon = FiltroLista[position]

        holder.pokemonName.text = pokemon.nome



        //carrega a imagem do Pokémon
        Picasso.get()
            .load("${pokemon.img}")
            .resize(150, 150)
            .into(holder.pokemonImage)
        holder.pokemonImage.run {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                clipToOutline = true
            }
        }

        holder.pokemonId.text = "Nº: " + pokemon.id.toString().padStart(3,'0')

        //aplica os drawables para o tipo de Pokémon
        holder.pokemonType1.setImageDrawable(
            typeSelector(
                holder.itemView.context,
                pokemon.tipo?.get(0)
            )
        )
        if (pokemon.tipo?.size!! > 1) {
            holder.pokemonType2.setImageDrawable(
                typeSelector(
                    holder.itemView.context,
                    pokemon.tipo[1]
                )
            )
        } else {
            holder.pokemonType2.setImageDrawable(null)
        }

        /* clicar em um Pokémon na lista navega para PokémonDetailsFragment, passando adiante
        as propriedades do Pokémon como argumentos
        */
        holder.pokemonImage.setOnClickListener {
            val action =
                listagemDosPokemonsDirections.actionPokemonListFragmentToPokemonDetailsFragment(
                    description = pokemon.desc!!,
                    name = pokemon.nome!!,
                    nameLowerCase = pokemon.nome.toLowerCase(),
                    number = pokemon.num!!,
                    height = pokemon.tamanho!!,
                    wight = pokemon.peso!!,
                    hp = pokemon.vida!!,
                    attack = pokemon.ataque!!,
                    defense = pokemon.defesa!!,
                    speed = pokemon.velocidade!!,
                    type = pokemon.tipo.toTypedArray(),
                    weaknesses = pokemon.fraqueza!!.toTypedArray(),

                    /*passa todas as evoluções seguintes e anteriores como um array
                    contendo o nome e o nível dessa evolução, passando uma string "nula" no caso de um parâmetro nulo
                    ex .: ["raichu", "16", "nenhum", "nenhum"]
                    */
                    nextEvolution = arrayOf(
                        pokemon.Evolucao?.getOrNull(0)?.nome.toString(),
                        pokemon.Evolucao?.getOrNull(0)?.evoLevel.toString(),
                        pokemon.Evolucao?.getOrNull(1)?.nome.toString(),
                        pokemon.Evolucao?.getOrNull(1)?.evoLevel.toString()
                    ),

                    prevEvolution = arrayOf(
                        pokemon.preEvolucao?.getOrNull(0)?.nome.toString(),
                        pokemon.preEvolucao?.getOrNull(0)?.evoLevel.toString(),
                        pokemon.preEvolucao?.getOrNull(1)?.nome.toString(),
                        pokemon.preEvolucao?.getOrNull(1)?.evoLevel.toString()
                    ),

                    )
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return FiltroLista.size

    }

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val pokemonName: TextView = view.findViewById(R.id.pokemonNome)
        val pokemonImage: ImageView = view.findViewById(R.id.pokemonImagem)
        val pokemonId: TextView = view.findViewById(R.id.pokemonId)
        val pokemonType1: ImageView = view.findViewById(R.id.tipo1)
        val pokemonType2: ImageView = view.findViewById(R.id.tipo2)
    }
}