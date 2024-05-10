package kz.vkInternship.pokemon.ui.pokemonDetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.get

@Composable
fun PokemonDetailsScreen(name: String, viewModel: PokemonDetailsScreenViewModel = get()){
    viewModel.getDetails(name)
    val details = viewModel.pokemonDetails.value
    Text(details.name)
}