package kz.vkInternship.pokemon.data.di

import kz.vkInternship.pokemon.data.repository.PokemonRepositoryImpl
import kz.vkInternship.pokemon.domain.repository.PokemonRepository
import org.koin.dsl.module


val repositoryModule = module {
    factory<PokemonRepository> { PokemonRepositoryImpl(get(), get(), get(), get(), get()) }
}