package kz.vkInternship.pokemon.ui.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kz.vkInternship.pokemon.ui.theme.DarkRedText
import kz.vkInternship.pokemon.ui.theme.OrangeBack
import java.util.Locale


@Composable
fun AbilityCard(name: String, abilities: List<String>) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = OrangeBack,
            contentColor = DarkRedText
        ),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.size(width = 200.dp, height = 160.dp).fillMaxHeight()
    ) {
        LazyColumn(
            modifier = Modifier.padding(start = 4.dp)
        ) {
            item {
                Row {
                    Text(
                        text = "Name: ",
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = name.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                        },
                    )
                }
            }
            item {
                abilities.forEach {
                    Row {
                        Text(
                            text = "Effects:",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Text(
                        text = it,
                        softWrap = true,
                        overflow = TextOverflow.Visible

                    )
                }
            }
        }
    }

//
//    Column {
//        abilities.forEach {
//            Card {
//                Column {
//                    Text(text = it.name)
//                    it.effects.forEach {
//                        Text(text = it.effect)
//                    }
//                }
//            }
//        }
//    }
}