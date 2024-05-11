package kz.vkInternship.pokemon.data.di

import kz.vkInternship.pokemon.data.use_cases.GetAbilityDetailsUseCaseImpl
import kz.vkInternship.pokemon.data.use_cases.GetPokemonDetailsUseCaseImpl
import kz.vkInternship.pokemon.data.use_cases.GetPokemonsUseCaseImpl
import kz.vkInternship.pokemon.data.use_cases.GetSpritesOfPokemonByIdOrNameImpl
import kz.vkInternship.pokemon.domain.use_cases.GetAbilityDetailsUseCase
import kz.vkInternship.pokemon.domain.use_cases.GetPokemonDetailsUseCase
import kz.vkInternship.pokemon.domain.use_cases.GetPokemonsUseCase
import kz.vkInternship.pokemon.domain.use_cases.GetSpritesOfPokemonByIdOrName
import org.koin.dsl.module


val useCaseModule = module {
    factory<GetPokemonsUseCase> { GetPokemonsUseCaseImpl(get()) }
    factory<GetSpritesOfPokemonByIdOrName> { GetSpritesOfPokemonByIdOrNameImpl(get()) }
    factory<GetPokemonDetailsUseCase> { GetPokemonDetailsUseCaseImpl(get()) }
    factory<GetAbilityDetailsUseCase> { GetAbilityDetailsUseCaseImpl(get()) }
}