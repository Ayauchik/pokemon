package kz.vkInternship.pokemon.data.network.response

data class Move(
    val move: Result,
    val version_group_details: List<VersionGroupDetail>
)