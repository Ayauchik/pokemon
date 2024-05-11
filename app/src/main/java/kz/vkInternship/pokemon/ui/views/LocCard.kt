package kz.vkInternship.pokemon.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.vkInternship.pokemon.ui.theme.DarkRedText
import kz.vkInternship.pokemon.ui.theme.OrangeBack
import java.util.Locale


@Composable
fun LocCard(locations: List<String>){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = OrangeBack,
            contentColor = DarkRedText
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 4.dp)
        ) {
            locations.forEach { location ->
                val formattedLocation = location.replace("-", " ")
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                Text(text = formattedLocation)
            }

        }
    }
}