package com.example.simulacro_tp3_ort_2.ui.views.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.simulacro_tp3_ort_2.R


class FragConfig : PreferenceFragmentCompat(){
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.config_screen, rootKey)
    }


}