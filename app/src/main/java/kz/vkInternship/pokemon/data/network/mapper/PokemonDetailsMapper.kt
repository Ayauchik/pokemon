package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.GetPokemonDetails
import kz.vkInternship.pokemon.domain.model.PokemonDetails

class PokemonDetailsMapper(
    private val statMapper: StatMapper,
    private val typeMapper: TypeMapper,
    private val abilityMapper: AbilityMapper,
    private val moveMapper: MoveMapper,
    private val formMapper: ResultMapper
) {

    fun fromRemoteToDomain(getPokemonDetails: GetPokemonDetails): PokemonDetails {
        return PokemonDetails(
            id = getPokemonDetails.id,
            name = getPokemonDetails.name,
            base_experience = getPokemonDetails.base_experience,
            height = getPokemonDetails.height,
            weight = getPokemonDetails.weight,
            location_area_encounters = getPokemonDetails.location_area_encounters,
            stats = getPokemonDetails.stats.map {
                statMapper.fromRemoteToDomain(it)
            },
            abilities = getPokemonDetails.abilities.map {
                abilityMapper.fromRemoteToDomain(it)
            },
            forms = getPokemonDetails.forms.map {
                formMapper.FromRemoteToDomain(it)
            },
            move = getPokemonDetails.moves.map {
                moveMapper.fromRemoteToDomain(it)
            },
            types = getPokemonDetails.types.map {
                typeMapper.FromRemoteToDomain(it)
            },
            frontUrl = getPokemonDetails.sprites.front_default
        )
    }
}