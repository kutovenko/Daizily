package com.blogspot.alexeykutovenko.daizily.utils

import java.util.*

object Locales {
    val english: Locale by lazy { Locale("en", "EN") }
    val russian: Locale by lazy { Locale("ru", "RU") }

    val RTL: Set<String> by lazy {
        hashSetOf(
            "ar",
            "dv",
            "fa",
            "ha",
            "he",
            "iw",
            "ji",
            "ps",
            "sd",
            "ug",
            "ur",
            "yi"
        )
    }
}
