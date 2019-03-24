package com.blogspot.alexeykutovenko.daizily.ui.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blogspot.alexeykutovenko.daizily.utils.LocaleHelper
import com.blogspot.alexeykutovenko.daizily.utils.Locales
import com.blogspot.alexeykutovenko.daizily.R
import kotlinx.android.synthetic.main.fragment_settings.*
import java.util.*


class SettingsFragment : Fragment() {

    private lateinit var listener: OnLocaleUpdated

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLocaleUpdated) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnOnLocaleUpdated.")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //todo
        when(context?.let { LocaleHelper.getLocale(it) }){
            Locales.english -> rbEn.isChecked = true
            Locales.russian -> rbRus.isChecked = true
        }

        rbEn.setOnClickListener{listener.onLocaleSelected(Locales.english)}
        rbRus.setOnClickListener{listener.onLocaleSelected(Locales.russian)}

    }

    interface OnLocaleUpdated {
        fun onLocaleSelected(locale: Locale)
    }

}
