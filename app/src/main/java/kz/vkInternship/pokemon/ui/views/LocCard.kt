package kz.vkInternship.pokemon.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kz.vkInternship.pokemon.ui.theme.DarkRedText
import kz.vkInternship.pokemon.ui.theme.OrangeBack
import java.util.Locale


@Composable
fun LocCard(locations: List<String>) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = OrangeBack,
            contentColor = DarkRedText
        ),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
           // .padding(vertical = 8.dp)
            .fillMaxWidth(0.5f)
            .size(height = 132.dp, width = 80.dp)

    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            items(locations) { location ->
                val formattedLocation = location.replace("-", " ")
                    .replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
                    }
                    .plus(",")
                Text(
                    text = formattedLocation,
                    softWrap = true,
                    overflow = TextOverflow.Visible
                )
            }
        }
    }
}