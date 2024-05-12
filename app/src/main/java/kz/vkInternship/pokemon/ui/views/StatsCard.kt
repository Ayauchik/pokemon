package kz.vkInternship.pokemon.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.vkInternship.pokemon.domain.model.Stat
import kz.vkInternship.pokemon.ui.theme.DarkRedText
import kz.vkInternship.pokemon.ui.theme.OrangeBack

@Composable
fun StatsCard(stats: List<Stat>){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = OrangeBack,
            contentColor = DarkRedText
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 4.dp, end = 8.dp)
        ) {
            stats.forEach{
                Row {
                    Text(text = "${it.stat.name}: ".replace("-", " "))
                    Text(text = it.base_stat.toString())
                }
            }
        }
    }
}