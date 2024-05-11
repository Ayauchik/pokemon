package kz.vkInternship.pokemon.data.use_cases

import kz.vkInternship.pokemon.domain.model.location.PokemonLocations
import kz.vkInternship.pokemon.domain.repository.PokemonRepository
import kz.vkInternship.pokemon.domain.use_cases.GetPokemonLocationsUseCase

class GetPokemonLocationsUseCaseImpl(
    private val pokemonRepository: PokemonRepository
): GetPokemonLocationsUseCase {
    override suspend fun invoke(name: String): PokemonLocations {
        return pokemonRepository.getPokemonLocations(name)
    }
}