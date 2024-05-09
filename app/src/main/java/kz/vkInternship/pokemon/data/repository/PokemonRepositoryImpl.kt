package kz.vkInternship.pokemon.data.repository

import kz.vkInternship.pokemon.data.network.api.PlaceholderService
import kz.vkInternship.pokemon.data.network.mapper.PokemonSpriteMapper
import kz.vkInternship.pokemon.data.network.mapper.PokemonsMapper
import kz.vkInternship.pokemon.domain.model.PokemonSprite
import kz.vkInternship.pokemon.domain.model.PokemonsModel
import kz.vkInternship.pokemon.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val pokemonsMapper: PokemonsMapper,
    private val pokemonSpriteMapper: PokemonSpriteMapper
) : PokemonRepository {
    override suspend fun getPokemons(): PokemonsModel {
        return pokemonsMapper.fromRemoteToDomain(placeholderService.getPokemons())
    }

    override suspend fun getSpritesOfPokemonByIdOrName(idOrName: Any): PokemonSprite {
        return pokemonSpriteMapper.fromRemoteToDomain(placeholderService.getSprites(idOrName))
    }
}