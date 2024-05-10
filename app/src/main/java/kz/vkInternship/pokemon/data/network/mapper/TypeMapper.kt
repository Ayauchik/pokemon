package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.Type

class TypeMapper(
    private val resultMapper: ResultMapper
) {
    fun FromRemoteToDomain(type: Type): kz.vkInternship.pokemon.domain.model.Type{
        return kz.vkInternship.pokemon.domain.model.Type(
            slot = type.slot,
            type = resultMapper.FromRemoteToDomain(type.type)
        )
    }
}