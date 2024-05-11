package kz.vkInternship.pokemon.ui.di

import kz.vkInternship.pokemon.ui.main.MainScreenViewModel
import kz.vkInternship.pokemon.ui.pokemonDetails.PokemonDetailsScreenViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainScreenViewModel(get(), get()) }
    factory { PokemonDetailsScreenViewModel(get()) }
}