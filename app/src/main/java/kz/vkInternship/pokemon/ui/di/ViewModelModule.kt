package kz.vkInternship.pokemon.ui.di

import kz.vkInternship.pokemon.ui.main.MainScreenViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainScreenViewModel(get(), get()) }
}