package kz.vkInternship.pokemon.ui.navigation

object Destinations {
    const val Main = "Main"

    object PokemonDetails {
        const val route = "PokemonDetails/{name}"
        const val nameArg = "name"

        fun createRoute(name: String): String {
            return "PokemonDetails/$name"
        }
    }
}