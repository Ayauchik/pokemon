package kz.vkInternship.pokemon.data.network.response.location

data class EncounterDetail(
    val chance: Int,
    val condition_values: List<ConditionValue>,
    val max_level: Int,
    val method: Method,
    val min_level: Int
)