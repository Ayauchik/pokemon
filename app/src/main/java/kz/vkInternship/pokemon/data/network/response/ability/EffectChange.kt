package kz.vkInternship.pokemon.data.network.response.ability

data class EffectChange(
    val effect_entries: List<EffectEntry>,
    val version_group: VersionGroup
)