package com.example.irokutest

import android.app.Application
import com.example.irokutest.inject.AppComponent
import com.example.irokutest.inject.AppModule
import com.example.irokutest.inject.DaggerAppComponent
import io.realm.Realm

class App : Application() {
    lateinit var appComponent: AppComponent
        protected set

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)

        Realm.init(this)
    }

    companion object {
        lateinit var instance: App
            private set
    }
}
