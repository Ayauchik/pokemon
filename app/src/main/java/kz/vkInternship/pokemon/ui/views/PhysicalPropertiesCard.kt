package kz.vkInternship.pokemon.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kz.vkInternship.pokemon.domain.model.PokemonDetails
import kz.vkInternship.pokemon.ui.theme.DarkRedText
import kz.vkInternship.pokemon.ui.theme.OrangeBack

@Composable
fun PhysicalPropertiesCard(details: PokemonDetails) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = OrangeBack,
            contentColor = DarkRedText
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            //  verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth(.95f)
                .padding(start = 4.dp)
        ) {

            Row {
                Text(
                    text = "Height: ",
                    fontWeight = FontWeight.SemiBold,
                )
                Text(text = "${details.height}")
            }
            Row {
                Text(
                    text = "Weight: ",
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = details.weight.toString())
            }

            Row {
                Text(
                    text = "Base Experience: ",
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = details.base_experience.toString())
            }


        }
    }
}