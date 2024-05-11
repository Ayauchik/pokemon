package kz.vkInternship.pokemon.data.network.mapper.pokemon

import kz.vkInternship.pokemon.data.network.mapper.EntryEffectsMapper
import kz.vkInternship.pokemon.data.network.response.ability.GetAbilityResponse
import kz.vkInternship.pokemon.domain.model.ability.PokemonAbilityDetails

class PokemonAbilityDetailsMapper(
    private val effectsMapper: EntryEffectsMapper
) {
    fun fromRemoteToDomain(getAbilityResponse: GetAbilityResponse): PokemonAbilityDetails{
        return PokemonAbilityDetails(
            id = getAbilityResponse.id,
            name = getAbilityResponse.name,
            effects = getAbilityResponse.effect_entries.map {
                effectsMapper.fromRemoteToDomain(it)
            }
        )
    }
}