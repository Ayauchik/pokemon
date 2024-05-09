package kz.vkInternship.pokemon.data.network.response

import com.google.gson.annotations.SerializedName

data class GetPokemonResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<Result>?
)