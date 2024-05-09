package kz.vkInternship.pokemon.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import kz.vkInternship.pokemon.ui.views.PokemonListItem
import org.koin.androidx.compose.get

@Composable
fun PokemonListScreen(viewModel: MainScreenViewModel = get()) {
    val pokemonList = viewModel.pokemonList.collectAsState()
    val pokemonMap = viewModel.pokemonSpritesMap
    val isLoading = viewModel.isLoading

    if (!isLoading.value){
        LazyColumn {
            items(pokemonList.value) { pokemon ->
                // PokemonListItem(name = pokemon.name, url = "")
                val name = pokemon.name
                val url = pokemonMap[pokemon.name]
                // Log.e("sending url", url.toString())
                PokemonListItem(pokemon.name, pokemonMap[pokemon.name]!! )
            }
        }
    }
}
