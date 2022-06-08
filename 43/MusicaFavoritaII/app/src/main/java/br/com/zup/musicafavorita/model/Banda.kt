package br.com.zup.musicafavorita.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Banda (private val imagem:Int, private val nome:String, private val detalhe:String):Parcelable{
    fun getImage() = this.imagem
    fun getName() = this.nome
    fun getDetail() = this.detalhe
}