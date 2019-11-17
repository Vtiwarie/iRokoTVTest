package com.example.irokutest.inject

import com.example.irokutest.App
import com.example.irokutest.MainActivity
import com.example.irokutest.ui.detail.DetailFragment
import com.example.irokutest.ui.list.ListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(app: App)
    fun inject(activity: MainActivity)
    fun inject(fragment: ListFragment)
    fun inject(fragment: DetailFragment)

}