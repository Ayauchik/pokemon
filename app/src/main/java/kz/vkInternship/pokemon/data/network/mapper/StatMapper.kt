package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.Stat

class StatMapper(
    private val resultMapper: ResultMapper
) {
    fun fromRemoteToDomain(stat: Stat): kz.vkInternship.pokemon.domain.model.Stat{
        return kz.vkInternship.pokemon.domain.model.Stat(
            base_stat = stat.base_stat,
            effort = stat.effort,
            stat = resultMapper.FromRemoteToDomain(stat.stat)
        )
    }
}