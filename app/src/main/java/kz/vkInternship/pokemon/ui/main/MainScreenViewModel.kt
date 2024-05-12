package kz.vkInternship.pokemon.ui.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
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

    private val _totalPokemons = mutableIntStateOf(0)
    val totalPokemons: State<Int> get() = _totalPokemons

    private var offset = 0
    private val limit = 20
    private val _currentPage = mutableIntStateOf(1)
    val currentPage: State<Int> get() = _currentPage


    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            try {
                val pokemons = getPokemonsUseCase.invoke(offset, limit)
                _totalPokemons.intValue = pokemons.count
                _pokemonList.value = pokemons.pokemons!!

                pokemons.pokemons.forEach {
                    val sprites = getSpritesOfPokemonByIdOrName.invoke(it.name)
                    _pokemonSpritesMap[it.name] = sprites.sprites.front_default
                }

                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching data: ${e.message}")
                _isLoading.value = false
                // Handle error if needed
            }
        }
    }

    fun onNextClicked() {
        _isLoading.value = true
        offset += limit
        _currentPage.intValue++
        getPokemonList()
    }

    fun onPreviousClicked() {
        _isLoading.value = true
        offset = maxOf(0, offset - limit)
        _currentPage.intValue++
        getPokemonList()
    }

    fun onPageClicked(page: Int){
        _isLoading.value = true
        offset = (page - 1)*limit
        _currentPage.intValue = page
        getPokemonList()
    }
}
