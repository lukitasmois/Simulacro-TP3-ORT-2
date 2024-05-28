package com.example.simulacro_tp3_ort_2.ui.views.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.simulacro_tp3_ort_2.R
import com.example.simulacro_tp3_ort_2.ui.views.fragments.FragHome
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.lay_activity_home)

        /*supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, FragHome())
        }*/
    }
}