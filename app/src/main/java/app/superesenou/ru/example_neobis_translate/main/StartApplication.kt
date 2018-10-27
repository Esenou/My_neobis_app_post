package app.superesenou.ru.example_neobis_translate.main

import android.app.Application
import android.app.Service

import app.superesenou.ru.example_neobis_translate.main.data.ForumService
import app.superesenou.ru.example_neobis_translate.main.data.Network




class StartApplication: Application() {
    private val BASE_URL="http://jsonplaceholder.typicode.com"
    private val BASE_URL_W="http://api.apixu.com"
    companion object {
        @Volatile lateinit var service:ForumService
        @Volatile lateinit var servicew:ForumService
    }

    override fun onCreate() {
        super.onCreate()
        service=Network.initService(BASE_URL)
        servicew=Network.initService(BASE_URL_W)
    }
}