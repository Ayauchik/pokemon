package kz.vkInternship.pokemon.domain.model.ability

data class PokemonAbilityDetails (
    val id: Int,
    val name: String,
    val effects: List<EffectEntries>
)