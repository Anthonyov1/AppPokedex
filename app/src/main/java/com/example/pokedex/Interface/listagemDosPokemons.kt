package com.example.pokedex.Interface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pokedex.Adaptador.pokemonAdaptador
import com.example.pokedex.Data.Fonte
import com.example.pokedex.databinding.PokemonListaFragmentBinding

class listagemDosPokemons : Fragment() {

    private var _vinc: PokemonListaFragmentBinding? = null
    private val vinculo get() = _vinc!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _vinc = PokemonListaFragmentBinding.inflate(inflater, container, false)
        return vinculo.root

    }

    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val pokemonData = Fonte().gsonFromJson(requireContext(), "pokedex.json")
        recyclerView = vinculo.recyclerView
        recyclerView.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)

        //pokemonData é um objeto PokemonResponse que contém uma lista de objetos do tipo Pokémon
        val adapter = pokemonAdaptador(pokemonData.pokemons ?: listOf())
        recyclerView.adapter = adapter

        // Configurando a busca
        vinculo.procuraDePokemon.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _vinc = null
    }

}
