package kz.vkInternship.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.vkInternship.pokemon.ui.main.PokemonListScreen
import kz.vkInternship.pokemon.ui.navigation.Destinations
import kz.vkInternship.pokemon.ui.pokemonDetails.PokemonDetailsScreen
import kz.vkInternship.pokemon.ui.theme.PokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonApp()
        }
    }
}


@Composable
fun PokemonApp() {
    PokemonTheme {
        val navController = rememberNavController()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(navController, startDestination = Destinations.Main) {
                composable(Destinations.Main) {
                    PokemonListScreen(navController)
                }
                composable(Destinations.PokemonDetails.route) { backStackEntry ->
                    val name =
                        backStackEntry.arguments?.getString(Destinations.PokemonDetails.nameArg)

                    PokemonDetailsScreen(name = name ?: "")
                }
            }
        }
    }
}


