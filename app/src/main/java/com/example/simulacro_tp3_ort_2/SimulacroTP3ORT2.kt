package com.example.simulacro_tp3_ort_2

import android.app.Application
import com.example.simulacro_tp3_ort_2.core.Config
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SimulacroTP3ORT2 : Application() {
    override fun onCreate() {
        super.onCreate()
        Config.url = "https://dog.ceo/"
    }
}