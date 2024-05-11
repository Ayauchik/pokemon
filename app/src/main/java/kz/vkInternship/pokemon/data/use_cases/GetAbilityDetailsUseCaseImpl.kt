package kz.vkInternship.pokemon.data.use_cases

import kz.vkInternship.pokemon.domain.model.ability.PokemonAbilityDetails
import kz.vkInternship.pokemon.domain.repository.PokemonRepository
import kz.vkInternship.pokemon.domain.use_cases.GetAbilityDetailsUseCase

class GetAbilityDetailsUseCaseImpl(
    private val pokemonRepository: PokemonRepository
):GetAbilityDetailsUseCase {
    override suspend fun invoke(name: String): PokemonAbilityDetails {
        return pokemonRepository.getAbilityDetails(name)
    }
}