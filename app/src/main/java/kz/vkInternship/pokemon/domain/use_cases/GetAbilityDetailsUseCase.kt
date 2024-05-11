package kz.vkInternship.pokemon.domain.use_cases

import kz.vkInternship.pokemon.domain.model.ability.PokemonAbilityDetails

interface GetAbilityDetailsUseCase {
    suspend fun invoke(name: String): PokemonAbilityDetails
}