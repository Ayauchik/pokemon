package kz.vkInternship.pokemon.data.network.mapper.pokemon

import kz.vkInternship.pokemon.data.network.response.location.GetPokemonLocations
import kz.vkInternship.pokemon.domain.model.location.PokemonLocations

class PokemonLocationsMapper() {
    fun fromRemoteToDomain(getPokemonLocations: GetPokemonLocations): PokemonLocations{
        val names = mutableListOf<String>()
        getPokemonLocations.forEach{
            names.add(it.location_area.name)
        }
        return PokemonLocations(
            name = names
        )
    }
}