package kz.vkInternship.pokemon.data.network.response

import kz.vkInternship.pokemon.data.network.response.generation.GenerationI
import kz.vkInternship.pokemon.data.network.response.generation.GenerationIi
import kz.vkInternship.pokemon.data.network.response.generation.GenerationIii
import kz.vkInternship.pokemon.data.network.response.generation.GenerationIv
import kz.vkInternship.pokemon.data.network.response.generation.GenerationV
import kz.vkInternship.pokemon.data.network.response.generation.GenerationVi
import kz.vkInternship.pokemon.data.network.response.generation.GenerationVii
import kz.vkInternship.pokemon.data.network.response.generation.GenerationViii

data class Versions(
    val generationi: GenerationI,
    val generationii: GenerationIi,
    val generationiii: GenerationIii,
    val generationiv: GenerationIv,
    val generationv: GenerationV,
    val generationvi: GenerationVi,
    val generationvii: GenerationVii,
    val generationviii: GenerationViii
)