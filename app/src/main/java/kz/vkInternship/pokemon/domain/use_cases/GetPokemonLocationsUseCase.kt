package kz.vkInternship.pokemon.domain.use_cases

import kz.vkInternship.pokemon.domain.model.location.PokemonLocations

interface GetPokemonLocationsUseCase {
    suspend fun invoke(name: String): PokemonLocations
}