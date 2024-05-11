package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.Result

class ResultMapper {
    fun FromRemoteToDomain(result: Result): kz.vkInternship.pokemon.domain.model.Result{
        return kz.vkInternship.pokemon.domain.model.Result(
            name = result.name,
            url = result.url
        )
    }
}