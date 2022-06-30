package br.com.zup.zoologico.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Animal(private var name:String,
             private var description:String) : Parcelable {
    fun getName() = this.name
    fun getDescription() = this.description

}