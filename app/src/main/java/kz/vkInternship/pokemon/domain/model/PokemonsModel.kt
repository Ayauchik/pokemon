package kz.vkInternship.pokemon.domain.model

data class PokemonsModel(
    val count: Int,
    val next: String?,
    val previous: String?,
    val pokemons: List<Pokemon>?
)