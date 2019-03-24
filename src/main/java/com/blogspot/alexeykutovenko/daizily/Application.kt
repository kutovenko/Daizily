package com.blogspot.alexeykutovenko.daizily

import android.content.Context
import android.content.res.Configuration
import com.zeugmasolutions.localehelper.LocaleAwareApplication
import com.zeugmasolutions.localehelper.LocaleHelperApplicationDelegate

class Application : LocaleAwareApplication() {
    private val localeAppDelegate = LocaleHelperApplicationDelegate()

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(localeAppDelegate.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localeAppDelegate.onConfigurationChanged(this)
    }
}