package kz.vkInternship.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import kz.vkInternship.pokemon.ui.main.PokemonListScreen
import kz.vkInternship.pokemon.ui.theme.PokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //testGlide()
                    PokemonListScreen()
                }
            }
        }
    }
}


@Composable
fun testGlide(url: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"){
AsyncImage(model = url, contentDescription ="pokemon front" )
}