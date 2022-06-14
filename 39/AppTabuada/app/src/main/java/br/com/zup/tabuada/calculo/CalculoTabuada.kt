package br.com.zup.tabuada.calculo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.tabuada.NUMBER
import br.com.zup.tabuada.home.MainActivity
import br.com.zup.tabuada.databinding.ActivityCalculoTabuadaBinding

class CalculoTabuada : AppCompatActivity() {
    private lateinit var binding: ActivityCalculoTabuadaBinding
    private lateinit var tabuada:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculoTabuadaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getNumber()

        binding.botaoRecalcular.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private fun getNumber(){
       val number = intent.getStringExtra(NUMBER)
        if (number != null) {
            getMath(number.toInt())
            showUser(number)
        }
    }
    private fun getMath(number:Int){
        this.tabuada = "$number x 0 = ${number * 0}\n$number x 1 = ${number * 1}\n$number x 2 = ${number * 2}\n$number x 3 = ${number * 3}\n" +
                "$number x 4 = ${number * 4}\n$number x 5 = ${number * 5}\n$number x 6 = ${number * 6}\n$number x 7 = ${number * 7}\n" +
                "$number x 8 = ${number * 8}\n$number x 9 = ${number * 9}\n$number x 10 = ${number * 10}"
    }
    private fun showUser(number: String) {
        val nome = "Tabuada do $number"
        binding.tituloTabuada.text = nome
        binding.exibicaoTabuada.text  = tabuada
    }
}