package kz.vkInternship.pokemon.domain.model

data class PokemonDetails(
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val weight: Int,
    val location_area_encounters: String,
    val stats: List<Stat>,
    val abilities: List<Ability>,
    val forms: List<Result>,
    val move: List<Move>,
    val types: List<Type>,
    val frontUrl: String
)
