package kz.vkInternship.pokemon.domain.use_cases

import kz.vkInternship.pokemon.domain.model.PokemonsModel

interface GetPokemonsUseCase {
    suspend fun invoke(offset: Int = 0, limit: Int = 20): PokemonsModel
}