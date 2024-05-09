package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.GetPokemonResponse
import kz.vkInternship.pokemon.data.network.response.Result
import kz.vkInternship.pokemon.domain.model.Pokemon

class PokemonMapper {
    fun fromRemoteToDomain(result: Result): Pokemon{
        return Pokemon(
            name = result.name,
            url = result.url
        )
    }
}