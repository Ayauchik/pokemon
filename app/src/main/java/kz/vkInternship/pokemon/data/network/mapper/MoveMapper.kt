package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.Move

class MoveMapper(
    private val resultMapper: ResultMapper,
    private val versionGroupDetailsMapper: versionGroupDetailsMapper
) {
    fun fromRemoteToDomain(move: Move): kz.vkInternship.pokemon.domain.model.Move {
        return kz.vkInternship.pokemon.domain.model.Move(
            move = resultMapper.FromRemoteToDomain(move.move),
            version_group_details = move.version_group_details.map {
                versionGroupDetailsMapper.fromRemoteToDomain(it)
            }
        )
    }
}