package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.ability.EffectEntryX
import kz.vkInternship.pokemon.domain.model.ability.EffectEntries

class EntryEffectsMapper(
    private val languageMapper: LanguageMapper
) {
    fun fromRemoteToDomain(effectEntry: EffectEntryX): EffectEntries{
        return EffectEntries(
            effect = effectEntry.effect,
            language = languageMapper.fromRemoteToDomain(effectEntry.language)
        )
    }
}