package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.GetPokemonResponse
import kz.vkInternship.pokemon.domain.model.PokemonsModel

class PokemonsMapper(
    private val pokemonMapper: PokemonMapper
) {
    fun fromRemoteToDomain(getPokemonResponse: GetPokemonResponse): PokemonsModel{
        return PokemonsModel(
            count = getPokemonResponse.count,
            next = getPokemonResponse.next,
            previous = getPokemonResponse.previous,
            pokemons = getPokemonResponse.results?.map {
                pokemonMapper.fromRemoteToDomain(it)
            }
        )
    }
}