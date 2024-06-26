package kz.vkInternship.pokemon.data.network.response.ability

data class GetAbilityResponse(
    val effect_changes: List<EffectChange>,
    val effect_entries: List<EffectEntryX>,
    val flavor_text_entries: List<FlavorTextEntry>,
    val generation: Generation,
    val id: Int,
    val is_main_series: Boolean,
    val name: String,
    val names: List<Name>,
    val pokemon: List<Pokemon>
)