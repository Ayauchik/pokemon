package kz.vkInternship.pokemon.data.network.response.ability

data class Pokemon(
    val is_hidden: Boolean,
    val pokemon: PokemonX,
    val slot: Int
)