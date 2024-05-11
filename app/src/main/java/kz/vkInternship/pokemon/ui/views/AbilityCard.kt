package kz.vkInternship.pokemon.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kz.vkInternship.pokemon.domain.model.Ability


@Composable
fun AbilityCard(abilities: List<Ability>) {
    Card {
        Column {
            abilities.forEach {
                Text(text = it.ability.name)
            }
        }
    }
}