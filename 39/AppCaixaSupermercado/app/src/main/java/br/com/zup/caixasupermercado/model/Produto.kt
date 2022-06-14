package br.com.zup.caixasupermercado.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Produto(private var nome:String,private var qtd:Int, private var valor:Double) : Parcelable {
    fun getNome() = this.nome
    fun getQtd() = this.qtd
    fun getValor() = this.valor
}