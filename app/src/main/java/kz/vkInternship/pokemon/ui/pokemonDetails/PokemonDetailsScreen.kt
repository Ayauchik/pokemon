package kz.vkInternship.pokemon.ui.pokemonDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import kz.vkInternship.pokemon.ui.theme.YellowBack
import kz.vkInternship.pokemon.ui.views.AbilityCard
import kz.vkInternship.pokemon.ui.views.PhysicalPropertiesCard
import org.koin.androidx.compose.get
import java.util.Locale

@Composable
fun PokemonDetailsScreen(name: String, viewModel: PokemonDetailsScreenViewModel = get()) {
    viewModel.getDetails(name)
    val details = viewModel.pokemonDetails.value
    val loading = viewModel.isLoading.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(YellowBack),
        contentAlignment = Alignment.TopCenter,
    ) {
        if (loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.Top,
                //   horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .border(4.dp, Color.Black)
            ) {
                item {
                    Row(
                        verticalAlignment = Alignment.Top,
//                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                        //  modifier = Modifier.border(4.dp, Color.Black)
                    ) {
                        Spacer(modifier = Modifier.size(4.dp))
                        SubcomposeAsyncImage(
                            model = details.frontUrl,
                            contentDescription = "Pokemon Front",
                            modifier = Modifier
                                .size(height = 220.dp, width = 180.dp)
                                .border(width = 4.dp, color = Color.Black),
                            contentScale = ContentScale.FillHeight,
                            loading = { CircularProgressIndicator() },
                        )
                        Spacer(modifier = Modifier.size(12.dp))
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = details.name.replaceFirstChar {
                                    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                                },
                                fontFamily = FontFamily.Monospace,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            PhysicalPropertiesCard(details = details)
                        }
                    }
                }
                item {
                    Text(details.name)
                }

                item {
                    AbilityCard(abilities = details.abilities)
                }
            }
        }
    }
}