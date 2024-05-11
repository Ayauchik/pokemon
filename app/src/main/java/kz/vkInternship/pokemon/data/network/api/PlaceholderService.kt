package kz.vkInternship.pokemon.data.network.api

import kz.vkInternship.pokemon.data.network.response.GetPokemonDetails
import kz.vkInternship.pokemon.data.network.response.GetPokemonResponse
import kz.vkInternship.pokemon.data.network.response.GetSprites
import kz.vkInternship.pokemon.data.network.response.ability.GetAbilityResponse
import kz.vkInternship.pokemon.data.network.response.location.GetPokemonLocations
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlaceholderService {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 20
    ): GetPokemonResponse

    @GET("pokemon-form/{idOrName}")
    suspend fun getSprites(
        @Path("idOrName") idOrName: Any
    ): GetSprites

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): GetPokemonDetails

    @GET("ability/{name}")
    suspend fun getAbilityDetails(
        @Path("name") name: String
    ): GetAbilityResponse

    @GET("pokemon/{name}/encounters")
    suspend fun getPokemonLocations(
        @Path("name") name: String
    ): GetPokemonLocations
}