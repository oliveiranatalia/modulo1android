package br.com.zup.musicafavorita.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Banda (private val imagem:Int):Parcelable{
    fun getImage() = this.imagem
}