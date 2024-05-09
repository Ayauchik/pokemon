package kz.vkInternship.pokemon.data.network.api

import kz.vkInternship.pokemon.data.network.response.GetPokemonResponse
import kz.vkInternship.pokemon.data.network.response.GetSprites
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
}