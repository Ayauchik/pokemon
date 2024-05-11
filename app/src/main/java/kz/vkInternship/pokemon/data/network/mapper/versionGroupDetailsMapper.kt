package kz.vkInternship.pokemon.data.network.mapper

class versionGroupDetailsMapper(
    private val resultMapper: ResultMapper
) {
    fun fromRemoteToDomain(versionGroupDetail: kz.vkInternship.pokemon.data.network.response.VersionGroupDetail): kz.vkInternship.pokemon.domain.model.VersionGroupDetail {
        return kz.vkInternship.pokemon.domain.model.VersionGroupDetail(
            level_learned_at = versionGroupDetail.level_learned_at,
            move_learn_method = resultMapper.FromRemoteToDomain(versionGroupDetail.move_learn_method),
            version_group = resultMapper.FromRemoteToDomain(versionGroupDetail.version_group)
        )
    }
}