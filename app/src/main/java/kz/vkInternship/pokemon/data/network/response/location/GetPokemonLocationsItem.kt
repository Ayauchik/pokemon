package kz.vkInternship.pokemon.data.network.response.location

data class GetPokemonLocationsItem(
    val location_area: LocationArea,
    val version_details: List<VersionDetail>
)