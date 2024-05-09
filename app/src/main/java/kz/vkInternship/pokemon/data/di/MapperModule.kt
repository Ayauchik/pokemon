package kz.vkInternship.pokemon.data.di

import kz.vkInternship.pokemon.data.network.mapper.PokemonMapper
import kz.vkInternship.pokemon.data.network.mapper.PokemonSpriteMapper
import kz.vkInternship.pokemon.data.network.mapper.PokemonsMapper
import kz.vkInternship.pokemon.data.network.mapper.SpritesMapper
import org.koin.dsl.module

val mapperModule = module {
    factory<PokemonMapper> { PokemonMapper() }
    factory<PokemonsMapper> { PokemonsMapper(get())}
    factory { SpritesMapper() }
    factory { PokemonSpriteMapper(get()) }
}