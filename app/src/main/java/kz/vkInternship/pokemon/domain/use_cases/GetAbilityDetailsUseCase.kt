package kz.vkInternship.pokemon.domain.use_cases

import kz.vkInternship.pokemon.domain.model.get.PokemonAbilityDetails

interface GetAbilityDetailsUseCase {
    suspend fun invoke(name: String): PokemonAbilityDetails
}