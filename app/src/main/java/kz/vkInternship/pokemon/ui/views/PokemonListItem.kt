package kz.vkInternship.pokemon.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import kz.vkInternship.pokemon.ui.theme.MainPageText
import kz.vkInternship.pokemon.ui.theme.OrangeBack
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListItem(name: String, url: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = OrangeBack
        ),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for the Pokemon image
            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(72.dp)
            ) {
                SubcomposeAsyncImage(
                    model = url,
                    contentDescription = "Pokemon Front",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit,
                    loading = { CircularProgressIndicator()}
                )
            }
            Text(
                text = name.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                style = TextStyle(fontSize = 20.sp),
                color = MainPageText,
                fontWeight = FontWeight.W800,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}
