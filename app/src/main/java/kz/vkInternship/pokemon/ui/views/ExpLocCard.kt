package kz.vkInternship.pokemon.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import kz.vkInternship.pokemon.domain.model.PokemonDetails
import kz.vkInternship.pokemon.ui.theme.DarkRedText
import kz.vkInternship.pokemon.ui.theme.OrangeBack


@Composable
fun ExpLocCard(details: PokemonDetails){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = OrangeBack,
            contentColor = DarkRedText
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {

        }
    }
}