package com.example.simulacro_tp3_ort_2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacro_tp3_ort_2.R
import com.example.simulacro_tp3_ort_2.domain.model.DogWithText
import com.example.simulacro_tp3_ort_2.holders.DogHolder
import com.example.simulacro_tp3_ort_2.listeners.ItemClickListener

class DogAdapter(
    var dogList: MutableList<DogWithText>,
    val saveClick : ItemClickListener
) : RecyclerView.Adapter<DogHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_dog, parent, false)
        return DogHolder(view)
    }

    override fun onBindViewHolder(holder: DogHolder, position: Int) {
        val dog = dogList[position]
        holder.setImage(dog.image)
        holder.setName(dog.name)
        holder.setBreed(dog.breed)
        holder.setSubBreed(dog.subBreed)
        holder.saveDog().setImageResource(if(dog.favorite) R.drawable.icon_saved else R.drawable.no_saved)
        holder.saveDog().setOnClickListener {
            saveClick.saveDog(dog)
        }
    }

    override fun getItemCount() = dogList.size

    fun updateList(newList: MutableList<DogWithText>) {
        dogList = newList.toMutableList()
        notifyDataSetChanged()
    }
}