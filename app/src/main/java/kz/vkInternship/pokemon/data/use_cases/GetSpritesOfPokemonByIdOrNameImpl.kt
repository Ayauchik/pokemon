package kz.vkInternship.pokemon.data.use_cases

import kz.vkInternship.pokemon.domain.model.PokemonSprite
import kz.vkInternship.pokemon.domain.repository.PokemonRepository
import kz.vkInternship.pokemon.domain.use_cases.GetSpritesOfPokemonByIdOrName

class GetSpritesOfPokemonByIdOrNameImpl(
    private val pokemonRepository: PokemonRepository
): GetSpritesOfPokemonByIdOrName {
    override suspend fun invoke(idOrName: Any): PokemonSprite {
        return pokemonRepository.getSpritesOfPokemonByIdOrName(idOrName)
    }
}