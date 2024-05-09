package kz.vkInternship.pokemon.ui.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kz.vkInternship.pokemon.domain.model.Pokemon
import kz.vkInternship.pokemon.domain.use_cases.GetPokemonsUseCase
import kz.vkInternship.pokemon.domain.use_cases.GetSpritesOfPokemonByIdOrName

class MainScreenViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val getSpritesOfPokemonByIdOrName: GetSpritesOfPokemonByIdOrName
) : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList: MutableStateFlow<List<Pokemon>> = _pokemonList

    private var _pokemonSpritesMap = mutableStateMapOf<String, String?>()
    val pokemonSpritesMap: SnapshotStateMap<String, String?> = _pokemonSpritesMap

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> get() = _isLoading
    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            try {
                val pokemons = getPokemonsUseCase.invoke()
                _pokemonList.value = pokemons.pokemons!!

                pokemons.pokemons.forEach {
                    val sprites = getSpritesOfPokemonByIdOrName.invoke(it.name)
                    //Log.e("sprites", sprites.sprites.toString())
                    _pokemonSpritesMap[it.name] = sprites.sprites.front_default
//                    _pokemonSpritesMap = _pokemonSpritesMap.value.toMutableMap().apply {
//                        sprites.sprites.front_default?.let { it1 -> put(it.name, it1) }
//                    }
                    //Log.e()
//                    mapOf( it.name to sprites.sprites.front_default)?.let { it1 ->
//                        _pokemonSpritesMap.emit(
//                            it1 as Map<String, String>
//                        )
//                    }
                }

                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching data: ${e.message}")
                _isLoading.value = false
                // Handle error if needed
            }
        }
    }
}
