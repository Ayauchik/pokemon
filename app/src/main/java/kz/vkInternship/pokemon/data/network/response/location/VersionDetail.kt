package kz.vkInternship.pokemon.data.network.response.location

data class VersionDetail(
    val encounter_details: List<EncounterDetail>,
    val max_chance: Int,
    val version: Version
)