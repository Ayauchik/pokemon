package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.Ability

class AbilityMapper(
    private val resultMapper: ResultMapper
) {
    fun fromRemoteToDomain(ability: Ability): kz.vkInternship.pokemon.domain.model.Ability {
        return kz.vkInternship.pokemon.domain.model.Ability(
            ability = resultMapper.FromRemoteToDomain(ability.ability),
            is_hidden = ability.is_hidden,
            slot = ability.slot
        )
    }
}