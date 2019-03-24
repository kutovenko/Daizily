package com.blogspot.alexeykutovenko.daizily.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.blogspot.alexeykutovenko.daizily.BaseActivity
import com.blogspot.alexeykutovenko.daizily.R
import com.blogspot.alexeykutovenko.daizily.ui.fragment.SettingsFragment
import com.blogspot.alexeykutovenko.daizily.ui.fragment.TomorrowFragment
import com.blogspot.alexeykutovenko.daizily.ui.fragment.dummy.DummyContent

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity(), SettingsFragment.OnLocaleUpdated,
    TomorrowFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO()
    }

    override fun onLocaleSelected(locale: Locale) {
        updateLocale(locale)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this,
            R.id.nav_host_fragment
        )

        NavigationUI.setupWithNavController(navigation, navController)
    }

    // Alternative to NavigationUI
    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }
}
