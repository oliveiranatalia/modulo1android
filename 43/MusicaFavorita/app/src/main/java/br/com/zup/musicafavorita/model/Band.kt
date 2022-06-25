package br.com.zup.musicafavorita.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Band (private val image:Int): Parcelable {
    fun getImage() = this.image
}

