package kz.vkInternship.pokemon.domain.model

data class Move(
    val move: Result,
    val version_group_details: List<VersionGroupDetail>
)