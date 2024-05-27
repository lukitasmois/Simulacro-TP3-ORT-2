package com.example.simulacro_tp3_ort_2.holders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simulacro_tp3_ort_2.R

class DogHolder( v : View): RecyclerView.ViewHolder(v) {
    private var view : View

    init {
        this.view = v
    }

    fun setImage(image: String?){
        val itemImage = view.findViewById<ImageView>(R.id.card_dog_image)
        Glide.with(view.context).load(image).centerCrop().into(itemImage)
    }

}