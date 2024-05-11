package kz.vkInternship.pokemon.data.repository

import kz.vkInternship.pokemon.data.network.api.PlaceholderService
import kz.vkInternship.pokemon.data.network.mapper.PokemonDetailsMapper
import kz.vkInternship.pokemon.data.network.mapper.PokemonSpriteMapper
import kz.vkInternship.pokemon.data.network.mapper.PokemonsMapper
import kz.vkInternship.pokemon.data.network.mapper.pokemon.PokemonAbilityDetailsMapper
import kz.vkInternship.pokemon.domain.model.PokemonDetails
import kz.vkInternship.pokemon.domain.model.PokemonSprite
import kz.vkInternship.pokemon.domain.model.PokemonsModel
import kz.vkInternship.pokemon.domain.model.get.PokemonAbilityDetails
import kz.vkInternship.pokemon.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val pokemonsMapper: PokemonsMapper,
    private val pokemonSpriteMapper: PokemonSpriteMapper,
    private val pokemonDetailsMapper: PokemonDetailsMapper,
    private val pokemonAbilityDetailsMapper: PokemonAbilityDetailsMapper
) : PokemonRepository {
    override suspend fun getPokemons(): PokemonsModel {
        return pokemonsMapper.fromRemoteToDomain(placeholderService.getPokemons())
    }

    override suspend fun getSpritesOfPokemonByIdOrName(idOrName: Any): PokemonSprite {
        return pokemonSpriteMapper.fromRemoteToDomain(placeholderService.getSprites(idOrName))
    }

    override suspend fun getPokemonDetails(name: String): PokemonDetails {
        return pokemonDetailsMapper.fromRemoteToDomain(placeholderService.getPokemonDetails(name))
    }

    override suspend fun getAbilityDetails(name: String): PokemonAbilityDetails {
        return pokemonAbilityDetailsMapper.fromRemoteToDomain(placeholderService.getAbilityDetails(name))
    }
}