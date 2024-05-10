package kz.vkInternship.pokemon.data.di

import kz.vkInternship.pokemon.data.network.mapper.AbilityMapper
import kz.vkInternship.pokemon.data.network.mapper.MoveMapper
import kz.vkInternship.pokemon.data.network.mapper.PokemonDetailsMapper
import kz.vkInternship.pokemon.data.network.mapper.PokemonMapper
import kz.vkInternship.pokemon.data.network.mapper.PokemonSpriteMapper
import kz.vkInternship.pokemon.data.network.mapper.PokemonsMapper
import kz.vkInternship.pokemon.data.network.mapper.ResultMapper
import kz.vkInternship.pokemon.data.network.mapper.SpritesMapper
import kz.vkInternship.pokemon.data.network.mapper.StatMapper
import kz.vkInternship.pokemon.data.network.mapper.TypeMapper
import kz.vkInternship.pokemon.data.network.mapper.versionGroupDetailsMapper
import org.koin.dsl.module

val mapperModule = module {
    factory<PokemonMapper> { PokemonMapper() }
    factory<PokemonsMapper> { PokemonsMapper(get()) }
    factory { SpritesMapper() }
    factory { PokemonSpriteMapper(get()) }
    factory { ResultMapper() }
    factory { AbilityMapper(get()) }
    factory { MoveMapper(get(), get()) }
    factory { PokemonDetailsMapper(get(), get(), get(), get(), get()) }
    factory { StatMapper(get()) }
    factory { TypeMapper(get()) }
    factory { versionGroupDetailsMapper(get()) }
}