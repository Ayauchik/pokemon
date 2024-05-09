package kz.vkInternship.pokemon.data.di

import kz.vkInternship.pokemon.data.network.api.PlaceholderService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory<Converter.Factory> { GsonConverterFactory.create() }
    factory { HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY } }

    factory<OkHttpClient> {
        OkHttpClient.Builder()
      //      .addInterceptor(get(HttpLoggingInterceptor::class))
            .build()
    }

    factory<Retrofit> {// (baseUrl: String) ->
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(get())
            .client(get())
            .build()
    }

    factory<PlaceholderService> {
        this.get<Retrofit>().create(PlaceholderService::class.java)
    }
}