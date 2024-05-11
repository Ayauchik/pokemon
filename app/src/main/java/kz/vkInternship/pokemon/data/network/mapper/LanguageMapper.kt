package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.domain.model.Language

//import kz.vkInternship.pokemon.data.network.response.ability.Language

class LanguageMapper {
    fun fromRemoteToDomain(language: kz.vkInternship.pokemon.data.network.response.ability.Language): Language {
        return Language(
            name = language.name,
            url = language.url
        )
    }
}