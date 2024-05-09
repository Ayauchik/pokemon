package kz.vkInternship.pokemon.ui.views
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PokemonListItem(name: String, url: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Placeholder for the Pokemon image
        Box(
            modifier = Modifier
                .padding(end = 16.dp)
                .size(72.dp)
        ) {
            AsyncImage(
                model = url ?: "", // URL of the Pokemon image
                contentDescription = "Pokemon Front",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
              //  requestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)
            )
        }
        Text(
            text = name,
            style = TextStyle(fontSize = 20.sp)
        )
    }
}
