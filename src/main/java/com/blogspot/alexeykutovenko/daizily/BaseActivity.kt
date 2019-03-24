package com.blogspot.alexeykutovenko.daizily

import android.content.Context
import android.os.Bundle
import com.zeugmasolutions.localehelper.LocaleAwareCompatActivity
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegateImpl
import java.util.*

/**
 * Based on https://github.com/zeugma-solutions/locale-helper-android
 */
open class BaseActivity : LocaleAwareCompatActivity() {
    private val localeDelegate = LocaleHelperActivityDelegateImpl()

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(localeDelegate.attachBaseContext(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        localeDelegate.onCreate(this)
    }

    override fun onResume() {
        super.onResume()
        localeDelegate.onResumed(this)
    }

    override fun onPause() {
        super.onPause()
        localeDelegate.onPaused()
    }

    override fun updateLocale(locale: Locale) {
        localeDelegate.setLocale(this, locale)
    }
}