package kz.vkInternship.pokemon.data.network.response

data class GetPokemonDetails(
    val abilities: List<Ability>,
    val base_experience: Int,
    val cries: Cries,
    val forms: List<Result>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_abilities: List<Any>,
    val past_types: List<Any>,
    val species: Result,
    val sprites: SpritesX,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)