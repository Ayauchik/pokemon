package kz.vkInternship.pokemon.domain.model.get

data class PokemonAbilityDetails (
    val id: Int,
    val name: String,
    val effects: List<EffectEntries>
)