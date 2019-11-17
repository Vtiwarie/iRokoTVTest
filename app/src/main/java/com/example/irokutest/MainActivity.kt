package com.example.irokutest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.irokutest.ui.base.BaseFragment
import com.example.irokutest.ui.list.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
        setContentView(R.layout.activity_main)

        //starting fragment
        navigateToFragment(ListFragment.newInstance())
    }

    fun navigateToFragment(fragment: BaseFragment<*, *>) {
        supportFragmentManager.beginTransaction()
            .replace(CONTAINER, fragment)
            .commit()
    }

    companion object {
        const val CONTAINER = R.id.container
    }
}
