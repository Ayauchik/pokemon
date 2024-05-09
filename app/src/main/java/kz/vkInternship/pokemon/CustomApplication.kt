package kz.vkInternship.pokemon

import android.app.Application
import kz.vkInternship.pokemon.data.di.mapperModule
import kz.vkInternship.pokemon.data.di.networkModule
import kz.vkInternship.pokemon.data.di.repositoryModule
import kz.vkInternship.pokemon.data.di.useCaseModule
import kz.vkInternship.pokemon.ui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf

class CustomApplication : Application() {
    private val modulesToUse = listOf(
        networkModule,
        repositoryModule,
        useCaseModule,
        viewModelModule,
        mapperModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@CustomApplication)
            parametersOf("https://krcm36-7e04a2616e2f.herokuapp.com")
            modules(modulesToUse)
        }
    }
}