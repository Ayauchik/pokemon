package kz.vkInternship.pokemon.ui.pokemonDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.vkInternship.pokemon.domain.model.PokemonDetails
import kz.vkInternship.pokemon.domain.use_cases.GetAbilityDetailsUseCase
import kz.vkInternship.pokemon.domain.use_cases.GetPokemonDetailsUseCase

class PokemonDetailsScreenViewModel(
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase,
    private val getAbilityDetailsUseCase: GetAbilityDetailsUseCase
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

//    private var _pokemonAbilities = mutableStateListOf<PokemonAbilityDetails>()
//    val pokemonAbilities: SnapshotStateList<PokemonAbilityDetails> = _pokemonAbilities

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

            _isLoading.value = false
        }
    }
}