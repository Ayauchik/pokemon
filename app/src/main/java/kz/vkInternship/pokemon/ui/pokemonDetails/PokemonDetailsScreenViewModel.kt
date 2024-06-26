package kz.vkInternship.pokemon.ui.pokemonDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.vkInternship.pokemon.domain.model.PokemonDetails
import kz.vkInternship.pokemon.domain.model.location.PokemonLocations
import kz.vkInternship.pokemon.domain.use_cases.GetAbilityDetailsUseCase
import kz.vkInternship.pokemon.domain.use_cases.GetPokemonDetailsUseCase
import kz.vkInternship.pokemon.domain.use_cases.GetPokemonLocationsUseCase

class PokemonDetailsScreenViewModel(
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase,
    private val getAbilityDetailsUseCase: GetAbilityDetailsUseCase,
    private val getPokemonLocationsUseCase: GetPokemonLocationsUseCase
) : ViewModel() {

    private val _pokemonDetails = mutableStateOf<PokemonDetails>(
        PokemonDetails(
            id = 0,
            name = "",
            base_experience = 0,
            height = 0,
            weight = 0,
            location_area_encounters = "",
            stats = emptyList(),
            abilities = emptyList(),
            forms = emptyList(),
            move = emptyList(),
            types = emptyList(),
            frontUrl = ""
        )
    )
    val pokemonDetails: State<PokemonDetails> get() = _pokemonDetails

    private val _pokemonLocations = mutableStateOf(PokemonLocations(emptyList()))
    val pokemonLocations: State<PokemonLocations> get() = _pokemonLocations

    private val _pokemonAbilities = mutableStateMapOf<String, List<String>>()
    val pokemonAbilities: SnapshotStateMap<String, List<String>> = _pokemonAbilities

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> get() = _isLoading

    fun getDetails(name: String) {
        viewModelScope.launch {
            val details = getPokemonDetailsUseCase.invoke(name)
            _pokemonDetails.value = details

            details.abilities.forEach { ability ->
                val abilityDetails = getAbilityDetailsUseCase.invoke(ability.ability.name)
                val effectLists = mutableListOf<String>()


                abilityDetails.effects.forEach {
                    if (it.language.name == "en") {
                        effectLists.add(it.effect)
                        _pokemonAbilities[abilityDetails.name] = effectLists
                    }
                }
                // _pokemonAbilities.add(abilityDetails)
            }

            val locations = getPokemonLocationsUseCase.invoke(name)
            _pokemonLocations.value = locations

            _isLoading.value = false
        }
    }
}