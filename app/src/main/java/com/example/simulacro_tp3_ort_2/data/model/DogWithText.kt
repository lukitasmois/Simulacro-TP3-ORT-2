package com.example.simulacro_tp3_ort_2.data.model

import android.os.Parcel
import android.os.Parcelable

data class DogWithText (
    val name: String,
    val image: String?,
    val breed : String?,
    val subBreed : String?
) : Parcelable {
    constructor(name: String, breed: String, subBreed: String) : this(name, null, null, null)

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(breed)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DogWithText> {
        override fun createFromParcel(parcel: Parcel): DogWithText {
            return DogWithText(parcel)
        }

        override fun newArray(size: Int): Array<DogWithText?> {
            return arrayOfNulls(size)
        }
    }
}