package com.example.pokedex.Interface

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.pokedex.databinding.PokemonDetalhesFragmentBinding
import com.example.pokedex.Tipos.coresDosTipos.typeColor
import com.example.pokedex.Tipos.selecionadorDosTipos.typeSelector
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception


@Suppress("UNREACHABLE_CODE")
class detalhesDoPokemon : Fragment() {


    private val args: detalhesDoPokemonArgs by navArgs()
    private var _vinc: PokemonDetalhesFragmentBinding? = null
    private val vinculo get() = _vinc!!

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _vinc = PokemonDetalhesFragmentBinding.inflate(inflater, container, false)
        return vinculo.root


    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vinculo.imagemPokeDetalhes

        vinculo.nomeDetalhes.text = args.name

        vinculo.pesoDetalhes.text = args.wight

        vinculo.tamanhoDetalhes.text = args.height

        vinculo.numeroDetalhes.text = args.number

        vinculo.descricaoDetalhes.text = args.description

        //sets drawable for pokemon type
        vinculo.tipoDetalhes1.setImageDrawable(typeSelector(requireContext(), args.type[0]))
        if (args.type.size > 1) {
            vinculo.tipoDetalhes2.setImageDrawable(typeSelector(requireContext(), args.type[1]))
        } else {
            vinculo.tipoDetalhes2.setImageDrawable(null)
        }

        //sets drawable for pokemon weaknesses
        vinculo.fraquezaDetalhes1.setImageDrawable(typeSelector(requireContext(), args.weaknesses[0]))
        if (args.weaknesses.size > 1) {
            vinculo.fraquezaDetalhes2.setImageDrawable(
                typeSelector(
                    requireContext(),
                    args.weaknesses[1]
                )
            )
        }
        if (args.weaknesses.size > 2) {
            vinculo.fraquezaDetalhes3.setImageDrawable(
                typeSelector(
                    requireContext(),
                    args.weaknesses[2]
                )
            )
        }
        if (args.weaknesses.size > 3) {
            vinculo.fraquezaDetalhes4.setImageDrawable(
                typeSelector(
                    requireContext(),
                    args.weaknesses[3]
                )
            )
        }
        if (args.weaknesses.size > 4) {
            vinculo.fraquezaDetalhes5.setImageDrawable(
                typeSelector(
                    requireContext(),
                    args.weaknesses[4]
                )
            )
        }
        if (args.weaknesses.size > 5) {
            vinculo.fraquezaDetalhes6.setImageDrawable(
                typeSelector(
                    requireContext(),
                    args.weaknesses[5]
                )
            )
        }
        if (args.weaknesses.size > 6) {
            vinculo.fraquezaDetalhes7.setImageDrawable(
                typeSelector(
                    requireContext(),
                    args.weaknesses[6]
                )
            )
        }

        //sets the background color of the evolution tree box based on the primary type of the pokemon
        val firstType = args.type[0]
        typeColor(requireContext(), firstType)?.let { vinculo.caixaDasEvolucoes.setBackgroundResource(it) }


        // if and else if testing 6 different conditions to establish in which evolution stage
        // pokemon is and modify "evolution" section

        Log.d("evolucao checker", args.nextEvolution?.get(2).toString())
        //pokemon is the first in a 3 pokemon evolution tree
        if (args.nextEvolution?.get(2)!! != "null") {
            vinculo.evolucao1.text = args.name
            vinculo.evolucao2.text = args.nextEvolution?.get(0)
            vinculo.evolucao3.text = args.nextEvolution?.get(2)
            vinculo.condicaoDeEvolucao1.text = args.nextEvolution?.get(1)
            vinculo.condicaoDeEvolucao2.text = args.nextEvolution?.get(3)
        }

        //pokemon is the second in a 3 pokemon evolution tree
        else if (args.nextEvolution?.get(0)!! != "null" && args.prevEvolution?.get(0)!! != "null") {
            vinculo.evolucao1.text = args.prevEvolution?.get(0)
            vinculo.evolucao2.text = args.name
            vinculo.evolucao3.text = args.nextEvolution?.get(0)
            vinculo.condicaoDeEvolucao1.text = args.prevEvolution?.get(1)
            vinculo.condicaoDeEvolucao2.text = args.nextEvolution?.get(1)
        }

        //pokemon is the third in a 3 pokemon evolution tree
        else if (args.prevEvolution?.get(2)!! != "null") {
            vinculo.evolucao1.text = args.prevEvolution?.get(0)
            vinculo.evolucao2.text = args.prevEvolution?.get(2)
            vinculo.evolucao3.text = args.name
            vinculo.condicaoDeEvolucao1.text = args.prevEvolution?.get(1)
            vinculo.condicaoDeEvolucao2.text = args.prevEvolution?.get(3)
        }

        //pokemon is the first of a 2 pokemon evolution tree
        else if (args.nextEvolution?.get(1)!! != "null" && args.prevEvolution!![0] == "null") {
            vinculo.evolucao1.text = args.name
            vinculo.evolucao2.text = args.nextEvolution?.get(0)
            vinculo.condicaoDeEvolucao1.text = args.nextEvolution?.get(1)
            vinculo.evolucao3.visibility = View.GONE
            vinculo.condicaoDeEvolucao2.visibility = View.GONE
        }

        //pokemon is the second of a 2 pokemon evolution tree
        else if (args.prevEvolution?.get(1)!! != "null" && args.nextEvolution!![0] == "null") {
            vinculo.evolucao1.text = args.prevEvolution?.get(0)
            vinculo.evolucao2.text = args.name
            vinculo.condicaoDeEvolucao1.text = args.prevEvolution?.get(1)
            vinculo.evolucao3.visibility = View.GONE
            vinculo.condicaoDeEvolucao2.visibility = View.GONE
        } else {
            vinculo.cardView.visibility = View.INVISIBLE
        }


        // adds pokemon pictures to the evolution tree
        Picasso.get()
            .load(
                "https://img.pokemondb.net/sprites/x-y/normal/${
                    vinculo.evolucao1.text.toString().toLowerCase()
                }.png"
            )
            .resize(200, 170)
            .into(vinculo.evolucaoImagem1)


        Picasso.get()
            .load(
                "https://img.pokemondb.net/sprites/x-y/normal/${
                    vinculo.evolucao2.text.toString().toLowerCase()
                }.png"
            )
            .resize(200, 170)
            .into(vinculo.evolucaoImagem2, object : Callback{
                override fun onSuccess() {
                    vinculo.caixaDasEvolucoes.visibility=View.VISIBLE
                }
                override fun onError(e: Exception?) {
                   Log.d("Image loading", "failed")
                }
            })


        if (vinculo.evolucao3.text.isNotBlank()) {
            Picasso.get()
                .load(
                    "https://img.pokemondb.net/sprites/x-y/normal/${
                        vinculo.evolucao3.text.toString().toLowerCase()
                    }.png"
                )
                .resize(200, 170)
                .into(vinculo.evolucaoimagem3)
        }


        // adds main pokemon picture
        Picasso.get()
            .load(
                "https://img.pokemondb.net/sprites/x-y/normal/${
                    args.nameLowerCase.replace(
                        "'",
                        ""
                    ).replace(". ", "-")
                }.png"
            )
            .resize(150, 150)

            .into(vinculo.imagemPokeDetalhes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _vinc = null
    }
}
