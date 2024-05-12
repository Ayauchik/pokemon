package kz.vkInternship.pokemon.ui.pokemonDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import kz.vkInternship.pokemon.ui.theme.MainPageText
import kz.vkInternship.pokemon.ui.theme.YellowBack
import kz.vkInternship.pokemon.ui.views.AbilityCard
import kz.vkInternship.pokemon.ui.views.LocCard
import kz.vkInternship.pokemon.ui.views.PhysicalPropertiesCard
import kz.vkInternship.pokemon.ui.views.StatsCard
import org.koin.androidx.compose.get
import java.util.Locale

@Composable
fun PokemonDetailsScreen(name: String, viewModel: PokemonDetailsScreenViewModel = get()) {
    viewModel.getDetails(name)

    val details = viewModel.pokemonDetails.value
    val abilities = viewModel.pokemonAbilities
    val loading = viewModel.isLoading.value
    val locations = viewModel.pokemonLocations.value
    val stats = details.stats

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
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    Row(
                        verticalAlignment = Alignment.Top,

                        ) {
                        Spacer(modifier = Modifier.size(4.dp))
                        SubcomposeAsyncImage(
                            model = details.frontUrl,
                            contentDescription = "Pokemon Front",
                            modifier = Modifier
                                .size(height = 160.dp, width = 160.dp),
                            contentScale = ContentScale.FillHeight,
                            loading = { CircularProgressIndicator() },
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = details.name.replaceFirstChar {
                                    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                                },
                                fontFamily = FontFamily.Monospace,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = MainPageText
                            )
                            Text(
                                text = "Properties",
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Monospace,
                                color = MainPageText,
                            )
                            PhysicalPropertiesCard(details = details)
                        }
                    }
                    Spacer(modifier = Modifier.size(4.dp))
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Column {
                            Text(
                                text = "Locations",
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Monospace,
                                color = MainPageText,
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            LocCard(locations = locations.name)

                        }
                        // Spacer(modifier = Modifier.size(12.dp))
                        Column {
                            Text(
                                text = "Stats",
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Monospace,
                                color = MainPageText,
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            StatsCard(stats = stats)
                        }
                    }
                }



                item {
                    Column {
                        Text(
                            text = "Abilities",
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Monospace,
                            color = MainPageText,
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        LazyRow {
                            abilities.forEach {
                                item {
                                    AbilityCard(name = it.key, abilities = it.value)
                                    Spacer(modifier = Modifier.size(12.dp))
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.size(12.dp))
                }
            }
        }
    }
}