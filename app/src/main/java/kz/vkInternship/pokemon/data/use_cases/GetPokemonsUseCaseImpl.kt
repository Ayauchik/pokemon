package kz.vkInternship.pokemon.data.use_cases

import kz.vkInternship.pokemon.domain.model.PokemonsModel
import kz.vkInternship.pokemon.domain.repository.PokemonRepository
import kz.vkInternship.pokemon.domain.use_cases.GetPokemonsUseCase

class GetPokemonsUseCaseImpl(
    private val pokemonRepository: PokemonRepository
): GetPokemonsUseCase {
    override suspend fun invoke(offset: Int, limit: Int): PokemonsModel {
        return pokemonRepository.getPokemons(offset, limit)
    }
}