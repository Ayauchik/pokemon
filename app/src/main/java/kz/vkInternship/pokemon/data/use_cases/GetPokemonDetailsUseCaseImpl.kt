package kz.vkInternship.pokemon.data.use_cases

import kz.vkInternship.pokemon.domain.model.PokemonDetails
import kz.vkInternship.pokemon.domain.repository.PokemonRepository
import kz.vkInternship.pokemon.domain.use_cases.GetPokemonDetailsUseCase

class GetPokemonDetailsUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : GetPokemonDetailsUseCase {
    override suspend fun invoke(name: String): PokemonDetails {
        return pokemonRepository.getPokemonDetails(name)
    }
}