package kz.vkInternship.pokemon.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kz.vkInternship.pokemon.ui.navigation.Destinations
import kz.vkInternship.pokemon.ui.navigation.PaginationControl
import kz.vkInternship.pokemon.ui.theme.YellowBack
import kz.vkInternship.pokemon.ui.views.PokemonListItem
import org.koin.androidx.compose.get

@Composable
fun PokemonListScreen(navController: NavController, viewModel: MainScreenViewModel = get()) {
    val pokemonList = viewModel.pokemonList.collectAsState()
    val pokemonMap = viewModel.pokemonSpritesMap
    val isLoading = viewModel.isLoading
    val totalCount = viewModel.totalPokemons


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(YellowBack),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading.value) {
            CircularProgressIndicator()
        } else {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PaginationControl(
                    currentPage = viewModel.currentPage.value,
                    totalPages = totalCount.value / 20 + 1,
                    onNextClicked = {
                        viewModel.onNextClicked()
                    },
                    onPreviousClicked = {
                        viewModel.onPreviousClicked()
                    }) {
                    viewModel.onPageClicked(it)
                }
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    //modifier = Modifier.background(YellowBack)
                ) {
//                    item {
//                        PaginationControl(
//                            currentPage = viewModel.currentPage.value,
//                            totalPages = totalCount.value / 20 + 1,
//                            onNextClicked = {
//                                viewModel.onNextClicked()
//                            },
//                            onPreviousClicked = {
//                                viewModel.onPreviousClicked()
//                            }) {
//                            viewModel.onPageClicked(it)
//                        }
//                    }
                    items(pokemonList.value) { pokemon ->
                        var url = pokemonMap[pokemon.name]
                        if (url == null) {
                            url = ""
                        }
                        PokemonListItem(pokemon.name, url) {
                            navController.navigate(
                                Destinations.PokemonDetails.createRoute(
                                    pokemon.name,
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
