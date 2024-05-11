package kz.vkInternship.pokemon.ui.navigation

object Destinations {
    const val Main = "Main"

    object PokemonDetails {
        const val route = "PokemonDetails/{name}"
        const val nameArg = "name"
       // const val urlArg = "url"


        fun createRoute(name: String): String {
            return "PokemonDetails/$name"
        }
/*
        fun createRoute(name: String, url: String): String {
            return "PokemonDetails/$name/$url"
        }*/
    }
}